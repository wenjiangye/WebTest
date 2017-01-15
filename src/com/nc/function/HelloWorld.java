package com.nc.function;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)  
public class HelloWorld {
     public String sayhello(String name)
     {
    	 return "Hello" + name;
     }
}
