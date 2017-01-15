package com.nc.function;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@WebService
@SOAPBinding(style = Style.RPC)
@Path(value = "/")
public class RestfulRegeditServiceImpl implements RestfulRegeditService {
	
    //����HTTP��GET���� 
    @Override
	@GET 
    // ���������������ݸ�ʽΪ"text/plain" 
    @Path("/username={name}&passwd={passwd}")
    @Produces("text/plain") 
    public String getClichedMessage(@PathParam("name") String username, @PathParam("passwd") String password) { 
            return "Hello " + username + "\n����:" + password; 
    } 
    
    @Override
	@GET 
    // ���������������ݸ�ʽΪ"text/plain" 
    @Path("/addnum/int1={int1}&int2={int2}")
    @Produces("text/plain") 
    public int addnum(@PathParam("int1") int i1, @PathParam("int2") int i2) {
		return i1 + i2;
	} 
}
