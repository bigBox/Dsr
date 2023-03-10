package com.dj.bms.modules.user.service.impl;

import com.dj.bms.common.beans.Page;
import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.dao.mapper.wrapper.update.UpdateWrapper;
import com.dj.bms.common.dto.UserExecution;
import com.dj.bms.common.enums.InsertUserEnum;
import com.dj.bms.common.enums.UpdateUserEnum;
import com.dj.bms.common.exception.OperationFailedException;
import com.dj.bms.common.exception.OperationRepeaException;
import com.dj.bms.common.exception.OperationSystemException;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.common.util.*;
import com.dj.bms.common.util.bcrypt.BCryptPasswordEncoder;
import com.dj.bms.modules.collect.service.CollectService;
import com.dj.bms.modules.comment.model.Comment;
import com.dj.bms.modules.comment.service.CommentService;
import com.dj.bms.modules.integral.model.Top100;
import com.dj.bms.modules.notice.service.NoticeService;
import com.dj.bms.modules.role.dto.RoleDTO;
import com.dj.bms.modules.role.service.RoleService;
import com.dj.bms.modules.user.dao.UserDao;
import com.dj.bms.modules.user.dto.UserDTO;
import com.dj.bms.modules.user.dto.UserRoleRelDTO;
import com.dj.bms.modules.user.model.User;
import com.dj.bms.modules.user.model.UserRoleRel;
import com.dj.bms.modules.user.service.UserRoleRelService;
import com.dj.bms.modules.user.service.UserService;
import com.dj.bms.store.StorageService;
import com.dj.bms.third.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractBaseServiceImpl<User, UserDTO> implements UserService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDao rootUserDao;

	@Autowired
	private StorageService storageService;

	// @Autowired
	// private TopicService topicService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private CollectService collectService;

	@Autowired
	private NoticeService noticeService;

	@Autowired
	private RedisService redisService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserRoleRelService userRoleRelService;

	/**
	 * ??????ID????????????
	 */
	@Override
	public User findById(Integer userId) {
		return rootUserDao.selectByUserId(userId);
	}

	/**
	 * ????????????????????????
	 */
	@Override
	public User findByName(String userName) {
		return rootUserDao.selectByUserName(userName);
	}

	/**
	 * ??????email????????????
	 */
	@Override
	public User findByEmail(String email) {
		return rootUserDao.selectByEmail(email);
	}

	/**
	 * ?????????????????????????????????
	 */
	@Override
	public User findByUserNameAndPassword(String userName, String password) {
		return rootUserDao.selectByUserNameAndPassword(userName, password);
	}

	/**
	 * ?????????????????????????????????
	 */
	@Override
	public User findByEmailAndPassword(String email, String password) {
		return rootUserDao.selectByEmailAndPassword(email, password);
	}

	/**
	 * ???????????????
	 */
	@Override
	public List<Top100> scores(Integer limit) {
		return rootUserDao.selectByScore(limit);
	}

	/**
	 * ?????????????????????????????????
	 */
	/*
	 * @Override public Page<User> page(Integer pageNumber, Integer pageSize) { List<User> list =
	 * rootUserDao.selectAll((pageNumber - 1) * pageSize, pageSize); int totalRow = rootUserDao.countUserAll(); return
	 * new Page<>(list, pageNumber, pageSize, totalRow); }
	 */

	/**
	 * ????????????
	 */
	@Transactional
	@Override
	public UserExecution updateUser(User user) {
		try {
			if (user == null) {
				throw new OperationRepeaException("???????????????");
			} else {
				int updateUser = rootUserDao.updateUser(user);
				User rootUser = rootUserDao.selectByUserName(user.getUserName());
				if (updateUser <= 0) {
					throw new OperationFailedException("????????????");
				} else {
					// ??????redis
					// ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
					// opsForValue.set(rootUser.getThirdAccessToken(), JsonUtil.objectToJson(rootUser));
					redisService.setString(rootUser.getThirdAccessToken(), JsonUtil.objectToJson(rootUser));
					return new UserExecution(user.getUserName(), UpdateUserEnum.SUCCESS, rootUser);
				}
			}
		} catch (OperationRepeaException e1) {
			throw e1;
		} catch (OperationFailedException e2) {
			throw e2;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new OperationSystemException("update RootUser erroe " + e.getMessage());
		}
	}

	/**
	 * ??????ID????????????
	 */
	@Override
	public void deleteUserById(Integer userId) {
		rootUserDao.deleteUserByUserId(userId);
	}

	/**
	 * ????????????????????????
	 */
	@Override
	public void deleteUserByName(String userName) {
		rootUserDao.deleteUserByUserName(userName);
	}

	/**
	 * ????????????
	 */
	@Transactional
	@Override
	public UserExecution save(User user) {
		try {
			if (user.getUserName() == null && user.getUserName().equals("")) {
				throw new OperationRepeaException("?????????????????????");
			}
			if (user.getPassword() == null && user.getPassword().equals("")) {
				throw new OperationRepeaException("??????????????????");
			}
			User userName = rootUserDao.selectByUserName(user.getUserName());
			if (userName != null) {
				throw new OperationRepeaException("???????????????");
			} else {
				int insertUser = rootUserDao.insertUser(user);
				User rootUser = rootUserDao.selectByUserName(user.getUserName());
				if (insertUser <= 0) {
					throw new OperationFailedException("????????????");
				} else {
					// ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
					// opsForValue.set(rootUser.getThirdAccessToken(), JsonUtil.objectToJson(rootUser));
					// redisService.setString(rootUser.getThirdAccessToken(), JsonUtil.objectToJson(rootUser));
					return new UserExecution(user.getUserName(), InsertUserEnum.SUCCESS, rootUser);
				}
			}
		} catch (OperationRepeaException e1) {
			throw e1;
		} catch (OperationFailedException e2) {
			throw e2;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new OperationSystemException("insert into RootUser error " + e.getMessage());
		}
	}

	public UserExecution createUser(String username, String password, String email, String userType, String thirdId) {
		User user = new User();
		user.setUserUid(IDGenerator.generateID());
		user.setUserName(username);
		// ??????????????????
		// user.setPassword(new BCryptPasswordEncoder().encode(password));
		user.setPassword(SimpleHashUtil.simpleHash("MD5", password, username, 1024).toHex());
		user.setScore(10);
		user.setEmail(email);
		user.setUrl(null);
		user.setThirdId(thirdId);
		user.setReceiveMsg(false);
		user.setCreateDate(new Date());
		user.setUpdateDate(null);
		user.setIsLocked(false);
		user.setThirdAccessToken(StringUtils.getUUID());
		user.setStatusCd("1000");
		user.setUserType(userType);
		user.setAvatar("/default/front/common/images/default-avatar.jpg");
		user.setSignature("????????????????????????????????????");
		return save(user);
	}

	/**
	 * ?????????????????????????????????
	 */
	@Override
	public int countUserAll() {
		return rootUserDao.countUserAll();
	}

	@Transactional
	@Override
	public void updateScore(Integer score, Integer userId) {
		rootUserDao.updateScore(score, userId);
	}

	/**
	 * ?????????
	 */
	@Override
	public int countScore(Integer userId) {
		return rootUserDao.countScore(userId);
	}

	@Override
	public int countToday() {
		return rootUserDao.countToday();
	}

	/**
	 * ????????????
	 */
	@Override
	@Transactional
	public void updateAvatar(String avatarBase64, String path, User user, HttpServletRequest request) {
		// ????????????
		String avatarURL = storageService.store(avatarBase64, Paths.get(path));
		user.setAvatar(avatarURL);
		user.setUpdateDate(new Date());
		// ????????????
		updateUser(user);
		// ????????????
		// topicService.updateTopicAvatar(user);
		// ???????????? session
		CookieAndSessionUtil.removeSession(request, "user");
		CookieAndSessionUtil.setSession(request, "user", user);
	}

	@Override
	public Page<User> pageForAdmin(String username, String email, Integer pageNumber, Integer pageSize) {
		List<User> list = rootUserDao.selectAllForAdmin(username, email, (pageNumber - 1) * pageSize, pageSize);
		int totalRow = countAllForAdmin(username, email);
		return new Page<>(list, pageNumber, pageSize, totalRow);
	}

	@Override
	public int countAllForAdmin(String username, String email) {
		return rootUserDao.countAllForAdmin(username, email);
	}

	/**
	 * ???????????????????????????????????????
	 */
	@Override
	public void updateAdmin(User user) {
		// ??????????????????????????????????????????
		if (!StringUtils.isEmpty(user.getPassword())) {
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		}
		user.setUpdateDate(new Date());
		updateUser(user);
	}

	/**
	 * ???????????????????????????????????????
	 */
	@Override
	@Transactional
	public void deleteAdmin(Integer id) {
		User user = findById(id);
		// ????????????
		// topicService.deleteByAuthor(user.getUserName());
		// ????????????
		// commentService.deleteByReplyAuthorName(user.getUserName());

		UpdateWrapper<Comment> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("user_id", user.getUserId());
		// ????????????
		commentService.remove(updateWrapper);
		// ????????????
		collectService.deleteByUid(user.getUserId());
		// ????????????
		noticeService.deleteByTargetAuthorName(user.getUserName());
		// ????????????
		deleteUserById(user.getUserId());
	}

	@Override
	public Function<? super UserDTO, ? extends User> getDTO2DOMapper() {
		return userDTO -> (User) BeanUtils.DTO2DO(userDTO, User.class);
	}

	@Override
	public Function<? super User, ? extends UserDTO> getDO2DTOMapper() {
		return user -> {
			UserDTO userDTO = (UserDTO) BeanUtils.DO2DTO(user, UserDTO.class);
			if (userDTO != null) {
				QueryWrapper<UserRoleRel> queryWrapper = new QueryWrapper<>();
				queryWrapper.eq("user_id", userDTO.getUserId());
				List<UserRoleRelDTO> userRoleRelDTOs = this.userRoleRelService.list(queryWrapper);
				List<String> roleIds = userRoleRelDTOs.stream().filter(Objects::nonNull).map(dto -> dto.getRoleId())
						.collect(Collectors.toList());
				if (CollectionUtils.isNotEmpty(roleIds)) {
					List<RoleDTO> roleDTOs = this.roleService.listBatchIds(roleIds);
					userDTO.setRoleDTOs(roleDTOs);
				}
			}
			return userDTO;
		};
	}

	@Override
	public BaseDao<User> getDao() {
		return rootUserDao;
	}

}