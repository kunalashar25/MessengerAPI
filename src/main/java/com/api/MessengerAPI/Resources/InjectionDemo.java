package com.api.MessengerAPI.Resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/injection")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectionDemo
{
	@GET
	@Path("annotations")
	public String getParamUsingAnnotation(@MatrixParam("matrixParam") String matrixParam)
	{
		return "Matrix Param value: " + matrixParam;
	}
}

/*
 * Matrix Param VS Query Param
 * URL with query params: http://some.where/thing?paramA=1&paramB=6542
 * URL with matrix params: http://some.where/thing;paramA=1;paramB=6542
 * 
 * At first sight matrix params seem to have only advantages:
 * more readable
 * no encoding and decoding of "&" in XML documents is required
 * URLs with "?" are not cached in many cases; URLs with matrix params are
 * cached
 * matrix parameters can appear everywhere in the path and are not limited to
 * its end
 * matrix parameters can have more than one value: paramA=val1,val2
 * 
 * But there are also disadvantages:
 * only a few frameworks like JAX-RS support matrix parameters
 * When a browser submits a form via GET, the params become query params. So it
 * ends up in two kinds of parameters for the same task. To not confuse users of
 * the REST services and limit the effort for the developers of the services, it
 * would be easier to use always query params - in this area.
 * 
 * The important difference is that matrix parameters apply to a particular path
 * element while query parameters apply to the request as a whole. This comes
 * into play when making a complex REST-style query to multiple levels of
 * resources and sub-resources:
 * 
 * http://example.com/res/categories;name=foo/objects;name=green/?page=1
 */