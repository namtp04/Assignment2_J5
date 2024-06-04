<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
      integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
      crossorigin="anonymous" referrerpolicy="no-referrer"/>
<div class="container">
    <ul class="navbar" style="list-style-type: none;">
        <li class="nav-item mb-3">
            <a href="/sell-management/index" class="navbar-brand">
                <i class="fa-solid fa-cart-shopping"></i>
                <span>Sales Management</span>
            </a>
        </li>
        <li class="nav-item mb-3">
            <a href="/product/list" class="navbar-brand">
                <i class="fa-solid fa-shirt"></i>
                <span>Product Management</span>
            </a>
        </li>
        <li class="nav-item mb-3">
            <a href="/color/list" class="navbar-brand">
                <i class="fa-solid fa-palette"></i>
                <span>Color Management</span>
            </a>
        </li>
        <li class="nav-item mb-3">
            <a href="/NSX/list" class="navbar-brand">
                <i class="fa-solid fa-ruler"></i>
                <span>Producer Management</span>
            </a>
        </li>
        <li class="nav-item mb-3">
            <a href="/product-type/list" class="navbar-brand">
                <i class="fa-brands fa-product-hunt"></i>
                <span>Product types Management</span>
            </a>
        </li>
        <li class="nav-item mb-3">
            <a href="/customer/index" class="navbar-brand">
                <i class="fa-solid fa-bars-progress"></i>
                <span>Manager Customer</span>

            </a>
        </li>
        <li class="nav-item mb-3">
            <a href="/staff/index" class="navbar-brand">
                <i class="fa-solid fa-person"></i>
                <span>Manager Staff</span>
            </a>
        </li>
        <li class="nav-item mb-3">
            <a href="/product-detail/list" class="navbar-brand">
                <i class="fa-solid fa-circle-info"></i>
                <span>Manager Product Detail</span>
            </a>
        </li>
        <li class="nav-item mb-3">
            <a href="/bill/index" class="navbar-brand">
                <i class="fa-solid fa-money-bill"></i>
                <span>Manager Order</span>
            </a>
        </li>
        <li class="nav-item mb-3">
            <a href="/bill-detail/index" class="navbar-brand">
                <i class="far fa-money-bill-alt"></i>
                <span>Manager Order Detail</span>
            </a>
        </li>
    </ul>
    <div>
        <c:if test="${not empty sessionScope.username}">
            <a href="/auth/logout" class="navbar-brand d-flex justify-content-start" onclick="return confirm('Are you sure want to logout?')">
                <i class="lni lni-exit"></i>
                <span>Logout</span>
            </a>
        </c:if>
        <c:if test="${empty sessionScope.username}">
            <a href="/auth/login" class="navbar-brand d-flex justify-content-end">
                <i class="fa-solid fa-arrow-right-to-bracket"></i>
                <span>Login</span>
            </a>
        </c:if>
        <a href="#" class="navbar-brand d-flex justify-content-center">
            <span>Trần Phương Nam</span>
        </a>
    </div>


</div>

