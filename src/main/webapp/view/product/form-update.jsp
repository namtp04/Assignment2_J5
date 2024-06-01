<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Product</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
            crossorigin="anonymous"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet"/>
</head>
<body>
<div class="offcanvas offcanvas-start" data-bs-scroll="true" data-bs-backdrop="false"
     tabindex="-1"
     id="offcanvasScrolling" aria-labelledby="offcanvasScrollingLabel">
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasScrollingLabel">
            <jsp:include page="../menu/navbar.jsp"></jsp:include>
        </h5>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas"
                aria-label="Close"></button>
    </div>
    <div class="offcanvas-body">
        <jsp:include page="../menu/menu.jsp"></jsp:include>
    </div>
</div>
<nav class="navbar navbar-expand-sm bg-body-tertiary">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <div class="container-fluid">
                        <aside id="sidebar">
                            <h4 data-bs-toggle="offcanvas"
                                data-bs-target="#offcanvasScrolling"
                                aria-controls="offcanvasScrolling" style="padding-top: 5px;"><i
                                    class="lni lni-text-align-left"></i></h4>
                        </aside>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <h1 class="text-center mb-3 mt-5">Update product</h1>
    <div class="card-body">
        <form action="/product/update" method="post">
            <div class="mb-3" style="display: none">
                <label class="form-label">ID</label>
                <input type="text" class="form-control" value="${product.id}" name="id">
                <c:if test="${not empty errors}">
                    <span class="text-danger">${errors['id']}</span>
                </c:if>
                <span class="text-danger">${error}</span>
            </div>

            <div class="mb-3">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" value="${product.ma}" name="ma">
                <c:if test="${not empty errors}">
                    <span class="text-danger">${errors['ma']}</span>
                </c:if>
                <span class="text-danger">${error}</span>
            </div>

            <div class="mb-3">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" value="${product.ten}" name="ten">
                <c:if test="${not empty errors}">
                    <span class="text-danger">${errors['ten']}</span>
                </c:if>
            </div>
            <div class="text-center">
                <a href="/product/list" class="btn btn-secondary">Back</a>
                <button type="submit" class="btn btn-outline-success"
                        onclick="return confirm('Are you want to update this item?')">Update
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
