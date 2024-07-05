<html>
<body>
     <h1>Welcome to the Library</h1><br>
     <div> ${msg} </div><br>
     <table border="2" width="70%" cellpadding="2">
     <tr>
     <th>Id</th>
     <th>Book</th>
     <th>Author</th>
     <th>Price</th>
     </tr>
     <c:forEach var="book" items="${books}">
     <tr>
     <td>${book.id}</td>
     <td>${book.name}</td>
     <td>${book.author}</td>
     <td>${book.price}</td>
     <td><a href="borrowForm/${book.id}">Borrow</a></td>
     </c:if>
     </tr>
     </c:forEach>
     </table>
     <br>
     <a href="addBookForm">Add a book </a>
    </body>
  </html>     