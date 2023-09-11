package com.example.wifi_info_in_korea;

import com.example.wifi_info_in_korea.DB.DBHistory;
import com.example.wifi_info_in_korea.dto.HistoryTableRow;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "History", value="/history.jsp")
public class History extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        String cellValue = request.getParameter("cellValue");
        DBHistory dbHistory = new DBHistory();

        if (cellValue != null && !cellValue.equals("")) {
            dbHistory.deleteRow(cellValue);
        }

        ArrayList<HistoryTableRow> rows = dbHistory.selectRow();

        // Create a StringBuilder to hold the HTML content
        StringBuilder htmlContent = new StringBuilder();

        // Add the HTML content to the StringBuilder
        htmlContent.append("<html>");
        htmlContent.append("<head>");
        htmlContent.append("<title>WIFI info Seoul</title>");
        htmlContent.append("<script>");
        htmlContent.append("function deleteData(button) {");
        htmlContent.append("var firstCell = button.parentNode.parentNode.cells[0];");
        htmlContent.append("var cellValue = firstCell.textContent;");
        htmlContent.append("window.location.href = url + '?' + 'cellValue=' + cellValue;");
        htmlContent.append("}");
        htmlContent.append("</script>");
        htmlContent.append("<style>");
        htmlContent.append("table {");
        htmlContent.append("width: 100%;");
        htmlContent.append("border-collapse: collapse;");
        htmlContent.append("}");
        htmlContent.append("th, td {");
        htmlContent.append("padding: 8px;");
        htmlContent.append("text-align: left;");
        htmlContent.append("border-bottom: 1px solid #ddd;");
        htmlContent.append("}");
        htmlContent.append("th {");
        htmlContent.append("background-color: green;");
        htmlContent.append("color: white;");
        htmlContent.append("}");
        htmlContent.append("tr:nth-child(even) {");
        htmlContent.append("background-color: #f2f2f2;");
        htmlContent.append("}");
        htmlContent.append("</style>");
        htmlContent.append("</head>");
        htmlContent.append("<body>");
        htmlContent.append("<h1>위치 히스토리 목록</h1>");
        htmlContent.append("<br/>");
        htmlContent.append("<a href=\".\">홈</a> |");
        htmlContent.append("<a href=\"history.jsp\">위치 히스토리 목록</a> |");
        htmlContent.append("<a href=\"apiRequest\">Open API 와이파이 정보 가져오기</a> |");
        htmlContent.append("<br/>");
        htmlContent.append("<table id=\"generatedTable\">");
        htmlContent.append("<thead>");
        htmlContent.append("<tr>");
        htmlContent.append("<th>ID</th>");
        htmlContent.append("<th>X좌표</th>");
        htmlContent.append("<th>Y좌표</th>");
        htmlContent.append("<th>조회일자</th>");
        htmlContent.append("<th>비고</th>");
        htmlContent.append("</tr>");
        htmlContent.append("</thead>");
        htmlContent.append("<tbody id=\"tableBody\">");
        for(HistoryTableRow row : rows){
            htmlContent.append("<tr>");
            htmlContent.append("<td>").append(row.getID()).append("</td>");
            htmlContent.append("<td>").append(row.getX()).append("</td>");
            htmlContent.append("<td>").append(row.getY()).append("</td>");
            htmlContent.append("<td>").append(row.getDATE()).append("</td>");
            htmlContent.append("<td>").append("<button onclick={deleteData(this)}>삭제</button>").append("</td>");
            htmlContent.append("</tr>");
        }

        htmlContent.append("</tbody>");
        htmlContent.append("</table>");
        htmlContent.append("</body>");
        htmlContent.append("</html>");
        // Hello
        PrintWriter out = response.getWriter();
        out.println(htmlContent.toString());
    }

    public void destroy() {
    }
}