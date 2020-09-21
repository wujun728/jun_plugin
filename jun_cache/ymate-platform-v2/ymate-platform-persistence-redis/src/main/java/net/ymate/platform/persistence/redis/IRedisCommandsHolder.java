/*
 * Copyright 2007-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ymate.platform.persistence.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.ShardedJedis;

/**
 * @author 刘镇 (suninformation@163.com) on 15/12/4 上午12:59
 * @version 1.0
 */
public interface IRedisCommandsHolder {

    /**
     * @return 获取数据源配置参数
     */
    RedisDataSourceCfgMeta getDataSourceCfgMeta();

    Jedis getJedis();

    ShardedJedis getShardedJedis();

    JedisCommands getCommands();

    void release();
}
