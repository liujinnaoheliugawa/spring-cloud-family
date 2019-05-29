package com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignClient.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-29
 */
public class FirstServerForeverRule extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        ILoadBalancer loadBalancer = getLoadBalancer();
        //返回三个配置的额 Server，即：
        //localhost:9090, localhost:9090 localhost:9090
        List<Server> allServers = loadBalancer.getAllServers();
        return allServers.get(0);
    }
}
