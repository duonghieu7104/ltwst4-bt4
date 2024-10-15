package vn.iostar.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iostar.entity.Category;
import vn.iostar.service.ICategoryService;
import vn.iostar.service.impl.CategoryServiceImpl;
import vn.iostar.utils.Constant;

@MultipartConfig()
@WebServlet(urlPatterns = { "/views", "/admin/categories", "/admin/category/add", "/admin/category/insert", "/admin/category/edit", "/admin/category/update", "/admin/category/delete" })
public class CategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ICategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();

        if (url.contains("/views")) {
            List<Category> list = cateService.findAll();
            req.setAttribute("listcate", list);
            req.getRequestDispatcher("/view/admin/category-list.jsp").forward(req, resp);

        } else if (url.contains("/admin/category/add")) {
            req.getRequestDispatcher("/view/admin/category-add.jsp").forward(req, resp);

        } else if (url.contains("/admin/category/edit")) {
            try {
                int id = Integer.parseInt(req.getParameter("id"));
                Category category = cateService.findById(id);
                req.setAttribute("cate", category);
                req.getRequestDispatcher("/view/admin/category-edit.jsp").forward(req, resp);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                resp.sendRedirect(req.getContextPath() + "/admin/categories");
            }

        } else {
            try {
                int id = Integer.parseInt(req.getParameter("id"));
                try {
					cateService.delete(id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                resp.sendRedirect(req.getContextPath() + "/admin/categories");
            } catch (NumberFormatException | IOException e) {
                e.printStackTrace();
                resp.sendRedirect(req.getContextPath() + "/admin/categories");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();

        if (url.contains("/admin/category/insert")) {
            String categoryname = req.getParameter("categoryname");
            int status = Integer.parseInt(req.getParameter("status"));
            String images = req.getParameter("images");

            Category category = new Category();
            category.setCategoryname(categoryname);
            category.setStatus(status);

            handleFileUpload(req, category, images);

            cateService.insert(category);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }

        if (url.contains("/admin/category/update")) {
            int categoryid = Integer.parseInt(req.getParameter("categoryid"));
            String categoryname = req.getParameter("categoryname");
            int status = Integer.parseInt(req.getParameter("status"));
            String images = req.getParameter("images");

            Category category = cateService.findById(categoryid);
            String fileold = category.getImages();
            category.setCategoryname(categoryname);
            category.setStatus(status);

            handleFileUpload(req, category, images, fileold);

            cateService.update(category);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }

    private void handleFileUpload(HttpServletRequest req, Category category, String images) throws IOException, ServletException {
        handleFileUpload(req, category, images, null);
    }

    private void handleFileUpload(HttpServletRequest req, Category category, String images, String fileold) throws IOException, ServletException {
        String fname = "";
        String uploadPath = Constant.UPLOAD_DIRECTORY;  // Sử dụng Constant.DIR thay vì constants.DIR
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        try {
            Part part = req.getPart("images1");
            if (part.getSize() > 0) {
                if (fileold != null && !fileold.substring(0, 5).equals("https")) {
                    deleteFile(uploadPath + "\\" + fileold);
                }

                String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                int index = filename.lastIndexOf(".");
                String ext = filename.substring(index + 1);
                fname = System.currentTimeMillis() + "." + ext;

                part.write(uploadPath + "/" + fname);
                category.setImages(fname);

            } else if (images != null) {
                category.setImages(images);

            } else {
                category.setImages(fileold != null ? fileold : "avatar.png");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.delete(path);
    }
}
