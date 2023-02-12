package com.dj.domain.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.google.common.io.CharSink;
import com.google.common.io.Files;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUtil {
	/**
	 * @Title: createFile
	 * @Description: 创建一个新文件
	 * @param data 数据
	 * @param path 文件路径
	 * @return void 返回类型
	 */
	public static void createFile(String data, String path) {
		try {
			File file = new File(path);
			// if file doesnt exists, then create it
			if (file.exists()) {
				file.delete();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			try (FileWriter fw = new FileWriter(file.getAbsoluteFile()); BufferedWriter bw = new BufferedWriter(fw)) {
				bw.write(data);
				log.info("Create new File data={} path={},done!", data, path);
			}
		} catch (IOException e) {
			log.error("Create new File data={} path={},error={}!", data, path, Utility.getTraceString(e));
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param filePath
	 * @return 删除结果
	 */
	public static boolean deleteFile(String filePath) {
		if (null == filePath)
			return true;
		File file = new File(filePath);
		if (!file.exists()) {
			return true;
		}
		try {
			return file.delete();
		} catch (Exception e) {
			log.error("delete file fail..", e);
			return false;
		}
	}

	/**
	 * 创建文件夹
	 * 
	 * @param fileDir
	 * @return
	 */
	public static File mkDir(String fileDir) {
		File file = new File(fileDir);
		if (!file.getParentFile().exists()) {
			mkDir(file.getParentFile());
		}
		file.mkdir();
		return file;
	}

	/**
	 * 创建文件夹
	 * 
	 * @param file
	 * @return
	 */
	public static File mkDir(File file) {
		if (!file.getParentFile().exists()) {
			mkDir(file.getParentFile());
		}
		file.mkdir();
		return file;
	}

	/**
	 * 创建文件
	 * 
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	public static File mkFile(String filePath, String fileName) {
		try {
			File path = mkDir(filePath);
			File file = new File(path, fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			return file;
		} catch (IOException e) {
			log.error("", e);
			return null;
		}
	}

	/**
	 * 保存文件
	 * 
	 * @param inputStream
	 * @param outputFile
	 * @return 保存结果
	 */
	public static boolean saveFile(InputStream inputStream, File outputFile) {
		try (FileOutputStream os = new FileOutputStream(outputFile)) {
			int byteRead = 0;
			byte[] bytes = new byte[1024];
			while ((byteRead = inputStream.read(bytes)) != -1) {
				os.write(bytes, 0, byteRead);
			}
		} catch (IOException e) {
			log.error("save file fail", e);
			return false;
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				log.error("save file fail", e);
			}
		}
		return true;
	}

	/**
	 * 将指定目录下的所有文件都取出来
	 * 
	 * @param f
	 * @param regex
	 * @return
	 */
	public static List<File> listAllFile(File f, String regex) {
		List<File> fileList = new ArrayList<File>();
		if (f != null) {
			if (f.isDirectory()) {
				File[] fileArray = f.listFiles();
				if (fileArray != null) {
					for (int i = 0; i < fileArray.length; i++) {
						// 递归调用
						fileList.addAll(listAllFile(fileArray[i], regex));
					}
				}
			} else {
				Pattern p = Pattern.compile(regex);
				if (!p.matcher(f.getPath()).find()) {
					fileList.add(f);
				}
			}
		}
		return fileList;
	}

	/**
	 * 复制文件
	 * 
	 * @param src
	 * @param dst
	 * @throws Exception
	 */
	public static void copyFile(File src, File dst) throws Exception {
		try (InputStream in = new BufferedInputStream(new FileInputStream(src), 1024);
				OutputStream out = new BufferedOutputStream(new FileOutputStream(dst), 1024)) {
			byte[] buffer = new byte[1024];
			int len;
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
		}
	}

	/**
	 * 读取文件
	 * 
	 * @param path
	 * @return
	 */
	public static String readFile(String path) {
		File file = new File(path);
		String content = null;
		if (file.exists()) {
			try {
				content = Files.asCharSource(file, Charset.defaultCharset()).read();
			} catch (IOException e) {
				log.error(Utility.getTraceString(e));
			}
		}
		return content;
	}

	/**
	 * 写入文件
	 * 
	 * @param filePath
	 * @param fileName
	 * @param content
	 */
	public static void writeFile(String filePath, String fileName, String content) {
		mkDir(filePath);
		File file = mkFile(filePath, fileName);
		CharSink sink = null;
		if (file.exists()) {
			sink = Files.asCharSink(file, Charset.defaultCharset());
			try {
				sink.write(content);
			} catch (IOException e) {
				log.error(Utility.getTraceString(e));
			}
		}
	}
}
