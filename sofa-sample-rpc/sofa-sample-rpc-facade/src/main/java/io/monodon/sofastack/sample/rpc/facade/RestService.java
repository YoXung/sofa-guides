package io.monodon.sofastack.sample.rpc.facade;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author yaoxiang
 * @description
 * @date 2024/6/27 下午5:58
 */
@Path("webapi")
@Consumes("application/json;charset=UTF-8")
@Produces("application/json;charset=UTF-8")
public interface RestService {
    @GET
    @Path("/rest/{str}")
    String sayRest(String str);
}
