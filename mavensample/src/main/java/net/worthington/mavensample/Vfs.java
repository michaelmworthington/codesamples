package net.worthington.mavensample;

import org.apache.commons.vfs2.AllFileSelector;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSelectInfo;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;

/**
 * Hello world!
 *
 */
public class Vfs {
    public static void main(String[] args) {

        FileSystemManager fsManager;
        try {
            fsManager = VFS.getManager();
            // FileObject directoryFileObject = fsManager.resolveFile("file:///Users/mworthington/Downloads/tmp2");
            FileObject directoryFileObject = fsManager.resolveFile("file://C:/Users/mworthington/Downloads/tmp");
            System.out.println(directoryFileObject.getName().getBaseName());

            FileObject[] fileObjects = directoryFileObject.findFiles(new AllFileSelector() {
                @Override
                public boolean traverseDescendents(FileSelectInfo info) {
                    return info.getDepth() == 0 || false;
                }

                @Override
                public boolean includeFile(FileSelectInfo info) {
                    // Never return the parent directory of a file list.
                    if (info.getDepth() == 0) {
                        return false;
                    }

                    FileObject fileObject = info.getFile();
                    System.out.println(fileObject);
                    
                    String name = info.getFile().getName().getBaseName();
                    System.out.println(name);
                    
                    boolean matches = true;
                    return matches;
                }
            });

            System.out.println(fileObjects);

            for ( int j = 0; j < fileObjects.length; j++ ) {
                FileObject fileObject = fileObjects[ j ];
                String str = fileObject.getName().getBaseName();
                System.out.println(str);

                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    System.out.println("Character: " + c + " value: " + Integer.toHexString(c));
                }
        
              }


        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }
}
