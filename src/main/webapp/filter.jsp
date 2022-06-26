<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="app"/>
<div class="card">

    <header class="card-header">
        <i class="icon-control fa fa-chevron-down"></i>
        <h6 class="title"><fmt:message key="products_services"/></h6>
    </header>

    <div class="card-body">

        <div class="input-group">
            <form class="pb">
                <div>
                    <input type="text" class="form-control" placeholder="<fmt:message key="search"/>">
                </div>
                <div class="input-group-append">
                    <button class="btn btn-light" type="button">
                        <i class="fa fa-search"><fmt:message key="search"/></i>
                    </button>
                </div>
            </form>
        </div>

        <div class="card-body">
            <div class="row-col-12">
                <div class="row">
                    <div class="col-6"><%--produit ou service--%>
                        <h5><input type="radio" checked="" name="type" value="product"><fmt:message key="product"/></h5>
                    </div>
                    <div class="col-6">
                        <h5><input type="radio" name="type" value="treatment"> <fmt:message key="treatment"/></h5>
                    </div>

                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="row-cols-12">
                            <label class="custom-control custom-checkbox">
                                <input type="checkbox" name="produit" checked=""
                                       class="custom-control-input"><fmt:message
                                    key="essentialOil"/>
                            </label>
                        </div>
                        <div class="row-cols-12">
                            <label class="custom-control custom-checkbox"> <input type="checkbox" name="produit"
                                                                                  checked=""
                                                                                  class="custom-control-input">
                                <fmt:message key="skinCare"/> </label>
                        </div>
                        <div class="row-cols-12">
                            <label class="custom-control custom-checkbox">
                                <input type="checkbox" name="produit" checked="" class="custom-control-input">
                                <fmt:message key="analgesic"/> </label>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="row-cols-12">

                            <label class="custom-control custom-checkbox">
                                <input type="checkbox" name="soin" checked=""
                                       class="custom-control-input"> <fmt:message key="massage"/>
                            </label>
                        </div>
                        <div class="row-cols-12">
                            <label class="custom-control custom-checkbox">
                                <input type="checkbox" name="soin" checked=""
                                       class="custom-control-input"> <fmt:message key="taping"/>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


</div>
<!-- card-body.// -->
<div class="card">
    <header class="card-header">
        <h5 class="title"><fmt:message key="pricerange"/></h5>
    </header>
    <div class="card-body">
        <label>0 $</label>
        <label for="slider">
            <input type="range" value="200" class="custom-range" id="slider" max="200"
                   onchange="sliding()">
        </label>
        <label>200 $</label>

        <p id="sliderValue"></p>
    </div>
    <button class="btn btn-block btn-primary"><fmt:message key="apply"/></button>
</div>
