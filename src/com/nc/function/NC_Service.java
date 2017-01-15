package com.nc.function;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@WebService 
@SOAPBinding(style = Style.RPC)  
@Path(value = "/")
public interface NC_Service {

	
	@GET
    @Path("/readRecordsFromNC?userName={userName}&pwd={pwd}")
	@Consumes(MediaType.APPLICATION_JSON)
    // 处理请求反馈的内容格式为"text/plain" 
    @Produces("text/plain") 
	public String readRecordsFromNC(
			@PathParam("userName")String userName,
			@PathParam("pwd")String pwd,
			@PathParam("modelCode")String modelCode,
			@PathParam("fieldSet")String fieldSet,
			@PathParam("queryConditon")String queryConditon);
	@GET
    @Path("/writeRecordsToNC?userName={userName}&pwd={pwd}")
	@Consumes(MediaType.APPLICATION_JSON)
    // 处理请求反馈的内容格式为"text/plain" 
    @Produces("text/plain") 
	public String writeRecordsToNC(
			@PathParam("userName")String userName,
			@PathParam("pwd")String pwd,
			@PathParam("modelCode") String modelCode,
			@PathParam("xmlStr") String xmlStr);

}
