
            <div class="card">

                <header class="card-header">
                    <i class="icon-control fa fa-chevron-down"></i>
                    <h6 class="title">Produits et services</h6>
                </header>

                <div class="card-body">
                    <form class="pb">
                        <div class="input-group">
                            <div>
                                <input type="text" class="form-control"
                                       placeholder="Recherche">
                            </div>
                            <div class="input-group-append">
                                <button class="btn btn-light" type="button">
                                    <i class="fa fa-search">Recherche</i></button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="card-body">
                    <table>
                        <thead>
                        <td>
                            <label>
                                <h5><input type="checkbox" checked="" class="custom-control-input">
                                    Produits</h5></label>
                        </td>
                        <td>
                            <label class="custom-control custom-checkbox">
                                <h5><input type="checkbox" checked="" name="Soins"
                                           class="custom-control-input"> Soins</h5>
                            </label>
                        </td>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <label class="custom-control custom-checkbox">
                                    <input type="checkbox" name="produit" checked=""
                                           class="custom-control-input">
                                    Huiles essentiels
                                </label>
                                <label class="custom-control custom-checkbox">
                                    <input type="checkbox" name="produit" checked=""
                                           class="custom-control-input"> Gamme visage</label>

                                <label class="custom-control custom-checkbox">
                                    <input type="checkbox" name="produit" checked=""
                                           class="custom-control-input">
                                    Anti-douleur

                                </label>
                            </td>
                            <td>

                                <label class="custom-control custom-checkbox">
                                    <input type="checkbox" name="soin" checked=""
                                           class="custom-control-input"> Massages
                                </label>
                                <label class="custom-control custom-checkbox">
                                    <input type="checkbox" name="soin" checked=""
                                           class="custom-control-input"> Tapping
                                </label>
                            </td>
                        </tr>

                        </tbody>
                    </table>


                </div> <!-- card-body.// -->
            </div>
            <div class="card">
                <header class="card-header">
                    <h5 class="title">Price range </h5>
                </header>
                <div class="card-body">
                    <label>0</label>
                    <label for="slider">
                        <input type="range"  value="200" class="custom-range" id="slider" max="200"
                               onchange="sliding()" >
                    </label>
                    <label>200</label>

                   <p id="sliderValue"></p>
                </div>
                <button class="btn btn-block btn-primary">Apply</button>
            </div>
