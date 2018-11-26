// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package restservices.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import restservices.consume.RestConsumer;
import restservices.proxies.HttpMethod;

public class postString extends CustomJavaAction<IMendixObject>
{
	private java.lang.String collectionUrl;
	private java.lang.String requestData;
	private java.lang.Boolean submitAsFormData;

	public postString(IContext context, java.lang.String collectionUrl, java.lang.String requestData, java.lang.Boolean submitAsFormData)
	{
		super(context);
		this.collectionUrl = collectionUrl;
		this.requestData = requestData;
		this.submitAsFormData = submitAsFormData;
	}

	@Override
	public IMendixObject executeAction() throws Exception
	{
		// BEGIN USER CODE
		return RestConsumer.request(getContext(), HttpMethod.POST, collectionUrl, null, null, submitAsFormData, requestData).getMendixObject();
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "postString";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}