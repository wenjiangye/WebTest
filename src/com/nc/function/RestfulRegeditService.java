package com.nc.function;

import java.io.IOException;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(value = "/")
@WebService
@SOAPBinding(style = Style.RPC)  
public interface RestfulRegeditService {
	
	@GET
    @Path("/username={name}&passwd={passwd}")
	@Consumes(MediaType.APPLICATION_JSON)
    // 处理请求反馈的内容格式为"text/plain" 
    @Produces("text/plain") 
	public String getClichedMessage(@PathParam("name") String username, @PathParam("passwd") String password) 
			throws IOException;
	
	@GET 
    // 处理请求反馈的内容格式为"text/plain" 
    @Path("/addnum/int1={int1}&int2={int2}")
    @Produces("text/plain") 
	public int addnum(@PathParam("int1") int i1, @PathParam("int2") int i2); 
} 
	
