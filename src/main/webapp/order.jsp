<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="productService" class="com.ds.service.ProductService" scope="session" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Pedido Confirmado</title>
    <meta name="viewport" content="width=device-width" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" lang="pt-br" />
    <link rel="stylesheet" type="text/css" href="global.css">
    <link rel="stylesheet" type="text/css" href="order.css">
</head>

<body bgcolor="#FFFFFF">

<table class="head-wrap" bgcolor="#4169e1">
    <tr>
        <td></td>
        <td class="header container">

            <div class="content">
                <table bgcolor="#4169e1">
                    <tr>
                        <td align="center">
                            <h6 class="collapse">Pedido Confirmado</h6>
                        </td>
                    </tr>
                </table>
            </div>

        </td>
        <td></td>
    </tr>
</table><!-- /HEADER -->


<!-- BODY -->
<table class="body-wrap">
    <tr>
        <td></td>
        <td class="container" bgcolor="#FFFFFF">

            <div class="content">
                <table>
                    <tr>
                        <td>
                            <br/>
                            <h3>Obrigado pelo seu pedido!</h3>

                            <p><img src="https://image.freepik.com/vetores-gratis/logotipo-burger_1366-145.jpg" alt="Fast food image" /></p>

                            <br/>

                            <h4>Seu pedido em <small>11 de Junho de 2020</small></h4>
                            <p>Obrigado por comprar no Wallace Donald's. Seu pedido foi finalizado com sucesso e ja esta sendo processado e preparado.</p>

                            <br/>

                            <!-- Line Items -->
                            <c:forEach items="${requestScope.products}" var="product">
                                <div class="products">
                                    <span> 1x ${product.name} / R$ ${product.price}</span>
                                </div>
                                <hr>
                                <div style="clear:both;"></div>
                            </c:forEach>
                            <!-- /Line Items -->

                            <br/>
                            <br/>

                            <h4><b>Total: R$ ${requestScope.total}</b></h4>

                            <br/>
                            <br/>
                        </td>
                    </tr>
                </table>
            </div>

        </td>
        <td></td>
    </tr>
</table>
<!-- /BODY -->

<!-- FOOTER -->
<table class="footer-wrap" bgcolor="#4169e1">
    <tr>
        <td class="container">
            <div class="content">
                <table>
                    <tr>
                        <td align="center">
                            <p>Obrigado por comprar no <a href="/" style="color:#111111;">Wallace Donald's</a>!</p>
                            <a href="/" title="Wallace Donald's"><img src="https://image.freepik.com/vetores-gratis/logotipo-burger_1366-145.jpg" style="width:40px;height:auto;" alt="Wallace donalds" /></a>
                            <br/><br/>
                            <p><strong><a href="" style="color:#111111;">wallace.donalds@outolook.com</a></strong></p>
                            <p><small>Wallace Donald's</small></p>
                        </td>
                    </tr>
                </table>
            </div>
        </td>
    </tr>
</table>
</body>
</html>
