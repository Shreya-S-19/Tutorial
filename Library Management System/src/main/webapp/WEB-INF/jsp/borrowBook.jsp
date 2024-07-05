<html>
<body>
     <h1>Borrow book</h1>
     <form:form method="post" action="/borrow">
     <table border="2" width="70%" cellpadding="2">
     <tr>
      <th>Id</th>
      <th>Book Name</th>
      <th>Author</th>
      <th>Price</th>
      <th>Status</th>
      </tr>
      <tr>
      <td>${book.id}</td>
      <td>${book.name}</td>
      <td>${book.author}</td>
      <td>${book.price}</td>
      <td>${book.status}</td>
      </tr>
      </table>
      <br /> <input type="submit" value="Borrow">
      <input type="hidden" name="id" value="${book.id}" />
      </form:form>
</body>
</html>      
      
 