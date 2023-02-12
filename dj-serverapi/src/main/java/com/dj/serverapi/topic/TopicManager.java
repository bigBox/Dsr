package com.dj.serverapi.topic;

import com.dj.domain.base.ITopicEvent;
import com.dj.domain.util.inf.IArgumentRunnable;
import com.dj.servercore.server.SocketServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RTopic;
import org.redisson.codec.JsonJacksonCodec;
import org.springframework.context.annotation.Bean;

@Slf4j
public final class TopicManager {

	private static class SingletonHolder {
		private static final TopicManager INSTANCE = new TopicManager();
	}

	public static final TopicManager getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * 发布主题
	 */
	public void publishTopic(ITopicEvent event) {
		log.info("publishTopic eventTopic = {}",event.getTopic());
		try{
			Redisson redisson = SocketServer.getRedisTemplate().getRedisson();
			RTopic rTopic = redisson.getTopic(event.getTopic(), new JsonJacksonCodec());
			long clientsPublishTopicResult = rTopic.publish(event);
			log.info("clientsPublishTopicResult = {},eventTopic = {},roleID = {}", clientsPublishTopicResult, event.getTopic(), event.getRoleID());
		}
		catch (Exception e){
			log.error(e.getMessage());
		}
	}

	/**
	 * 监听主题
	 * 
	 * @param topic
	 */
	@Bean
	public void listenTopic(String topic, IArgumentRunnable<ITopicEvent> argument) {
		if(StringUtils.isEmpty(topic))return;
		log.info("listenTopic topic = {}",topic);
		try{
			Redisson redisson = SocketServer.getRedisTemplate().getRedisson();
			RTopic rTopic = redisson.getTopic(topic, new JsonJacksonCodec());
			rTopic.addListener(ITopicEvent.class, (charSequence, event) -> {
				System.out.println("onMessage:"+charSequence+"; Thread: "+Thread.currentThread().toString());
				System.out.println(event.getRoleID()+" topic : "+event.getTopic());
				argument.run(event);
			});
		}catch (Exception e){
			log.error(e.getMessage());
		}
	}
}