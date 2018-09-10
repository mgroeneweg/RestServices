// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package communitycommons.actions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Reads contents from a FileDocument and stores it in a file on the local (server) storage.
 */
public class FileFromFileDocument extends CustomJavaAction<Boolean>
{
	private String targetFile;
	private IMendixObject __fileDocument;
	private system.proxies.FileDocument fileDocument;

	public FileFromFileDocument(IContext context, String targetFile, IMendixObject fileDocument)
	{
		super(context);
		this.targetFile = targetFile;
		this.__fileDocument = fileDocument;
	}

	@Override
	public Boolean executeAction() throws Exception
	{
		this.fileDocument = __fileDocument == null ? null : system.proxies.FileDocument.initialize(getContext(), __fileDocument);

		// BEGIN USER CODE
		File output = new File(targetFile);
		
		try (
			FileOutputStream fos = new FileOutputStream(output);
			InputStream is = Core.getFileDocumentContent(getContext(), fileDocument.getMendixObject());
		) {
			IOUtils.copy(is, fos);
		}
		
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "FileFromFileDocument";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
