import java.util.HashMap;
import java.util.Map;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;

import jdk.nashorn.api.scripting.ScriptObjectMirror;



@SuppressWarnings({"removal"})
public class TestJs {

	public static ScriptEngine engine;
	
	private static String str;
	
	
	public static void main(String[] args) throws Exception {
		ScriptEngineManager sem = new ScriptEngineManager();
		engine = sem.getEngineByName("javascript");
		getJsValue();
		System.out.println("----------");
		getObject();
		System.out.println("----------");
		putValue();
		System.out.println("----------");
		callJsFunction();
	}


	private static void callJsFunction() throws Exception {
		engine.eval("function add(a, b){return a+b;}");
		Invocable jsInvoke = (Invocable) engine;
		Object res = jsInvoke.invokeFunction("add", new Object[]{10, 5});
		System.out.println(res);
	}


	private static void putValue() throws Exception {
		str = "Math.pow(a, b)";
		Map<String, Object> input = new HashMap<String, Object>(2);
		input.put("a", 2);
		input.put("b", 8);
		System.out.println(engine.eval(str, new SimpleBindings(input)));
	}


	private static void getObject() throws Exception {
		str = "  var obj=new Object();     "
            + "  obj.info='hello world';   "
            + "  obj.getInfo=function(){   "
            + "        return this.info;   "
            + "  };                        ";
		engine.eval(str);
		ScriptObjectMirror obj = (ScriptObjectMirror) engine.get("obj");
		System.out.println(obj.get("info"));
		System.out.println(obj.get("getInfo"));
		
		str = "obj.getInfo()";
		System.out.println(engine.eval(str));
	}


	/**
	 * 该函数测试Java获取js变量值的能力
	 * @throws Exception 
	 */
	private static void getJsValue() throws Exception {
		str = "  var msg='hello';          "
            + "  var number = 123;         "
            + "  var array=['A','B','C'];  "
            + "  var json={                "
            + "      'name':'pd',          "
            + "      'subjson':{           "
            + "           'subname':'spd'  "
            + "           ,'id':123        "
            + "           }                "
            + "      };                    ";
		
		engine.eval(str);
		str = "msg += ' world'; number += 5";
		engine.eval(str);
		System.out.println(engine.get("msg"));
		System.out.println(engine.get("number"));
		
		ScriptObjectMirror array = (ScriptObjectMirror) engine.get("array");
		System.out.println(array.getSlot(1));
		
		ScriptObjectMirror json = (ScriptObjectMirror) engine.get("json");
		System.out.println(json.get("name"));
		
		ScriptObjectMirror subjson = (ScriptObjectMirror) json.get("subjson");
		System.out.println(subjson.get("subname"));
	}
}
