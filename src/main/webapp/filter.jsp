<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="app"/>
<form action="<%-- a faire        --%>" method="post">
    <div class="card">

        <header class="card-header">
            <i class="icon-control fa fa-chevron-down"></i>
            <h5 class="title ps-5"><fmt:message key="products_services"/></h5>
        </header>

        <div class="card-body">

            <div class="input-group">

                <div>
                    <input type="text" class="form-control" placeholder="<fmt:message key="search"/>">
                </div>
                <div class="input-group-append ps-2">
                    <button class="btn btn-light" type="button">
                        <i class="fa fa-search"><fmt:message key="search"/></i>
                    </button>
                </div>

            </div>

            <div class="card-body">
                <div class="row-col-12">
                    <div class="row">
                        <div class="col-6"><%--produit ou service--%>
                            <h5><input type="radio" checked="" id="product" name="type" value="0"><fmt:message key="product"/>
                            </h5>
                        </div>
                        <div class="col-6">
                            <h5><input type="radio" name="type" id="treatment" value="1"> <fmt:message key="treatment"/></h5>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-6" id="productOn">
                            <div class="row-cols-12">
                                <label class="custom-control custom-checkbox">
                                    <input type="checkbox" name="choix" id="he" checked="" class="custom-control-input">
                                    <fmt:message key="essentialOil"/></label>
                            </div>
                            <div class="row-cols-12">
                                <label class="custom-control custom-checkbox">
                                    <input type="checkbox" name="choix" id="skin" checked="" class="custom-control-input">
                                    <fmt:message key="skinCare"/> </label>
                            </div>
                            <div class="row-cols-12">
                                <label class="custom-control custom-checkbox">
                                    <input type="checkbox" name="choix" id="analgesic" checked="" class="custom-control-input">
                                    <fmt:message key="analgesic"/> </label>
                            </div>
                        </div>
                        <div class="col-6" id="treatmentOn">
                            <div class="row-cols-12">

                                <label class="custom-control custom-checkbox">
                                    <input type="checkbox" id="massage" disabled="" name="choix" class="custom-control-input">
                                    <fmt:message key="massage"/>
                                </label>
                            </div>
                            <div class="row-cols-12">
                                <label class="custom-control custom-checkbox">
                                    <input type="checkbox" id="tapping" disabled="" name="choix" class="custom-control-input">
                                    <fmt:message key="taping"/>
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
            <h5 class="title ps-5"><fmt:message key="pricerange"/></h5>
        </header>
        <div class="card-body ps-5">
            <label>0 $</label>
            <label for="slider">
                <input type="range" value="200" class="custom-range" id="slider" max="200"
                       onchange="sliding()">
            </label>
            <label>200 $</label>

            <p id="sliderValue"></p>
            <button class="btn btn-block btn-primary"><fmt:message key="apply"/></button>
        </div>

    </div>
</form>