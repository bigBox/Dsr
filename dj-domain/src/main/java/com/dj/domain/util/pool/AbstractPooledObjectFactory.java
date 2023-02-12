package com.dj.domain.util.pool;

import org.apache.commons.pool2.BaseKeyedPooledObjectFactory;
import org.apache.commons.pool2.KeyedObjectPool;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;

import com.dj.domain.util.Utility;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@SuppressWarnings({"unchecked","deprecation"})
public class AbstractPooledObjectFactory extends BaseKeyedPooledObjectFactory<String, Object> {

    /**
     * @Field pool : 对象池
     */
    private KeyedObjectPool<String, Object> pool = null;

    /**
     * @return AbstractPoolableObjectFactory
     * @Title init
     * @Description 初始化对象池
     */
    protected AbstractPooledObjectFactory init(int maxTotalPerKey, int minIdlePerKey) {
        AbstractPooledObjectFactory factory = new AbstractPooledObjectFactory();
        GenericKeyedObjectPoolConfig config = new GenericKeyedObjectPoolConfig();
        // 获取资源时 最大阻塞等待3000ms
        config.setMaxWaitMillis(3000);
        config.setBlockWhenExhausted(true);
        // 设置最大对象数量
        config.setMaxTotalPerKey(maxTotalPerKey);
        // 设置最大最小空闲对象数量
        config.setMinIdlePerKey(minIdlePerKey);
        config.setMaxIdlePerKey((int) (minIdlePerKey / 0.75F));
        pool = new GenericKeyedObjectPool<>(factory, config);
        return factory;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Object create(String key) throws Exception {
        if (key == null || !(key instanceof String) || "".equals(key)) {
            throw new RuntimeException("No such class！");
        }
        Class cls = Class.forName(key);
        return cls.newInstance();
    }

    @Override
    public PooledObject<Object> wrap(Object value) {
        return new DefaultPooledObject<>(value);
    }

    /**
     * @return void
     * @Title: clear
     * @Description: 关闭对象池
     */
    public void close() {
    }

    /**
     * @return Object
     * @throws Exception
     * @Title borrowObject
     * @Description 从池中获取资源的逻辑
     * <p>
     * 1： 如果 blockWhenExhausted 配置的 为
     * false，从资源池中获取资源，如果获取不到，则判断当前池中的对象数量是否超过了 maxTotal 设置的数量，如果没有超过，
     * 则通过调用factory.makeObject() 创建对象，并将对象放入池中，执行第2步 。如果超过了，则返回
     * null，逻辑到此结束。 如果 blockWhenExhausted 配置的 为 true
     * ，从资源池中获取资源，如果获取不到，则判断当前池中的对象数量是否超过了 maxTotal 设置的数量，如果没有超过，
     * 则通过调用factory.makeObject() 创建对象，并将对象放入池中，执行第2步 。如果超过了，则阻塞等待，如果
     * MaxWaitMillis 配置的为 -1 则 阻塞等待，直到有可用的资源为止。 如果 maxWaitMillis 配置为
     * 1000 则 阻塞等待 1000毫秒，如果有可用资源，执行第2步，如果没有则返回 null，逻辑到此结束。
     * <p>
     * 2：将资源的状态 修改为 已分配，执行 第 3 步
     * <p>
     * 3：调用 factory.activateObject() 方法，执行 第 4步
     * <p>
     * 4：如果 testOnBorrow 或者 testOnCreate 中有一个 配置 为 true 时，则调用
     * factory.validateObject() 方法
     * <p>
     * 5：以上步骤都完成了，返回资源对象
     */
    @SuppressWarnings("rawtypes")
    public Object borrowObject(Class objClass) {
        Object ret = null;
        try {
            ret = pool.borrowObject(objClass.getName());
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
        }
        return ret;
    }

    /**
     * @param obj
     * @return void
     * @throws Exception
     * @Title returnObject
     * @Description 归还一个对象
     * <p>
     * 1：检查配置参数 testOnReturn，如果 为 true，调用
     * factory.validateObject()方法，验证资源对象的有效性，验证结果为 true，则调用
     * factory.destroyObject()方法，逻辑到此结束。 验证结果为 false，则执行第 2 步。
     * <p>
     * 2：调用 factory.passivateObject()方法，然后执行 第 3 步
     * <p>
     * 3：将资源的状态 修改为 未分配，执行第 4 步
     * <p>
     * 4：进行判断 （ 资源池是否关闭 || （maxIdle > -1 ) && ( maxIdle <= 资源池空闲资源个数) ）
     * 如果 判断为 true，则调用 factory.destroyObject()方法，逻辑到此结束。 如果 判断为 false，则
     * 将资源返还给资源池，逻辑到此结束。
     */
    public void returnObject(Object obj) {
        try {
            pool.returnObject(obj.getClass().getName(), obj);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
        }finally {
            return;
        }
    }
}