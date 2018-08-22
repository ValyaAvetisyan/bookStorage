package servlet;

import manager.PostManager;
import model.Post;
import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/addPostServlet")
public class AddPostServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (isMultipart) {
            String imageUploadPath = "D:\\Blog\\images\\";

            DiskFileItemFactory factory = new DiskFileItemFactory();

            // maximum size that will be stored in memory
            factory.setSizeThreshold(50 * 1024);

            // Location to save data that is larger than maxMemSize.
            factory.setRepository(new File("D:\\temp"));

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // maximum file size to be uploaded.
            upload.setSizeMax(500 * 1024);

            try {
                // Parse the request to get file items.
                List<FileItem> fileItems = upload.parseRequest(req);
                String title = "";
                String text = "";
                String categoryId = "";
                String picUrl = "";
                for (FileItem fileItem : fileItems) {
                    if (fileItem.isFormField()) {
                        if (fileItem.getFieldName().equals("title")) {
                            title = fileItem.getString();
                        } else if (fileItem.getFieldName().equals("text")) {
                            text = fileItem.getString();
                        } else if (fileItem.getFieldName().equals("categoryId")) {
                            categoryId = fileItem.getString();
                        }
                    } else {
                        String picName = System.currentTimeMillis() + "_" + fileItem.getName();
                        File file = new File(imageUploadPath + picName);
                        fileItem.write(file);
                        picUrl = picName;
                    }


                }
                User user = (User) req.getSession().getAttribute("user");

                Post post = new Post();
                post.setTitle(title);
                post.setText(text);
                post.setCategoryId(Integer.parseInt(categoryId));
                post.setUserId(user.getId());
                post.setPicUrl(picUrl);
                PostManager postManager = new PostManager();
                try {
                    postManager.add(post);
                    resp.sendRedirect("/admin");
                } catch (SQLException e) {
                    e.printStackTrace();
                }



            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}