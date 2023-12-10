<template>
    <div id = "container"></div> 
    <div class = "colorPalette">
        <span class = "black color-span"             ></span>
        <span class = "gray color-span"              ></span>
        <span class = "intermediateGray color-span"  ></span>
        <span class = "lightGray color-span"         ></span>
        <span class = "veryLightGray color-span"     ></span>
        <span class = "white color-span"             ></span>
        <span class = "red color-span"               ></span>
        <span class = "lightRed color-span"          ></span>
        <span class = "pink color-span"              ></span>
        <span class = "lightPurple color-span"       ></span>
        <span class = "intermediatePurple color-span"></span>
        <span class = "purple color-span"            ></span>
        <span class = "sky color-span"               ></span>
        <span class = "intermediateSky color-span"   ></span>
        <span class = "lightSky color-span"          ></span>
        <span class = "lightBlue color-span"         ></span>
        <span class = "intermediateBlue color-span"  ></span>
        <span class = "blue color-span"              ></span>
        <span class = "green color-span"             ></span>
        <span class = "intermediateGreen color-span" ></span>
        <span class = "lightGreen color-span"        ></span>
        <span class = "yellow color-span"            ></span>
        <span class = "lightOrange color-span"       ></span>
        <span class = "orange color-span"            ></span>
    </div>
    
    <div class = "options">
        <div class = "line">
            <p>Specifiy the start point and the end point of the line</p>
            <button class = "btn btn-outline-primary" @click = "drawLine">OK</button>
        </div>
        <div class = "circle">
            <label>radius</label> <input type = "text" id = "radius">
            <button class = "btn btn-outline-primary" @click = "drawCircle">OK</button>
        </div>
        <div class = "ellipse">
            <label>radius (x)</label> <input type = "text" id = "radiusX"> <br>
            <label>radius (y)</label> <input type = "text" id = "radiusY">
            <button class = "btn btn-outline-primary" @click = "drawEllipse">OK</button>
        </div>
        <div class = "triangle">
            <p>Specifiy the three vertices of the triangle</p>
            <button class = "btn btn-outline-primary" @click = "drawTriangle">OK</button>
        </div>
        <div class = "rectangle">
            <label>width </label> <input type = "text" id = "width"> <br>
            <label>height</label> <input type = "text" id = "height">
            <button class = "btn btn-outline-primary" @click = "drawRectangle">OK</button>
        </div>
        <div class = "square">
            <label>length</label> <input type="text" id = "length">
            <button class = "btn btn-outline-primary" @click = "drawSquare">OK</button>
        </div>
    </div>

    <div class = "shapeBar">
        <div @click = "showHideLineOption"      ><img width = "60" height = "60" src = "https://img.icons8.com/ios/50/ffffff/line--v1.png"                     /></div>
        <div @click = "showHideCircleOption"    ><img width = "60" height = "60" src = "https://img.icons8.com/ios/50/ffffff/circled.png"                      /></div>
        <div @click = "showHideEllipseOption"   ><img width = "60" height = "60" src = "https://img.icons8.com/ios/50/ffffff/ellipse-stroked--v1.png"          /></div>
        <div @click = "showHideTriangleOption"  ><img width = "60" height = "60" src = "https://img.icons8.com/ios/50/ffffff/trine-120.png"                    /></div>
        <div @click = "showHideRectangleOption" ><img width = "60" height = "60" src = "https://img.icons8.com/fluency-systems-regular/48/ffffff/rectangle.png"/></div>
        <div @click = "showHideSquareOption"    ><img width = "60" height = "60" src = "https://img.icons8.com/ios/50/ffffff/square-90.png"                    /></div>
    </div>

        <div class = "save">
            <div class = "saveXML" style="display: none;">
            </div>
            <div class = "saveJSON">
                <form class="saveForm">
                    <label>Enter Location</label>
                    <input type="text" name="saveLoc" required/> <br>
                    <label><input type="radio" name="JSON">JSON&nbsp;</label>
                    <label><input type="radio" name="XML">XML&nbsp;</label>
                    <label><input type="radio" name="BOTH">BOTH </label><br>
                    <button type="submit" @click="saveData">Save</button>
                </form>
                <!-- <button @click="$refs.file.click()">open file dialog</button> -->
            </div>
        </div>

        <div class = "load">
            <div class = "loadXML" style="display: none;">
            </div>
            <div class = "loadJSON">
                <label>File to load&nbsp;&nbsp;</label>
                <!-- <input type="file" ref="file" accept="application/json, application/xml" @change="loadFileFn"/> -->
                <input type="text" v-model="file">
                <button @click="loadData">Load</button>
            </div>
        </div>
    
    <div class = "sideBar">
        <div @click = "showHideShapeBar"    ><img width = "40" height = "40" src = "https://img.icons8.com/external-becris-lineal-becris/64/ffffff/external-shapes-coding-programming-becris-lineal-becris.png"/></div>
        <div @click = "showHideColorPalette"><img width = "40" height = "40" src = "https://img.icons8.com/ios/50/ffffff/paint.png"                        /></div>
        <div @click = "resize"              ><img width = "40" height = "40" src = "https://img.icons8.com/ios/50/ffffff/resize-diagonal--v1.png"          /></div>
        <div @click = "move"                ><img width = "40" height = "40"  src = "https://img.icons8.com/ios/50/ffffff/move.png"                        /></div>
        <div @click = "copySelectedShape"   ><img width = "40" height = "40"  src = "https://img.icons8.com/fluency-systems-regular/48/ffffff/copy--v1.png"/></div>
        <div @click = "deleteShape"         ><img width = "40" height = "40"  src = "https://img.icons8.com/carbon-copy/100/ffffff/filled-trash.png"       /></div>
        <div @click = "undo"         ><img width = "40" height = "40"  src = "https://img.icons8.com/ios/50/ffffff/undo.png"                                                        /></div>
        <div @click = "redo"         ><img width = "40" height = "40"  src = "https://img.icons8.com/ios/50/ffffff/redo--v1.png"                                                    /></div>
        <div @click = "showHideSave"        ><img width = "40" height = "40"  src = "https://img.icons8.com/ios/50/ffffff/save--v1.png"                    /></div>
        <div @click = "showHideLoad"        ><img width = "40" height = "40"  src = "https://img.icons8.com/pastel-glyph/64/ffffff/upload--v1.png"         /></div>
    </div>
</template> 
<script> 

    import Konva from 'konva' ;
    
    var layer            = new Konva.Layer() ;
    var newLine          = null ;
    var newCircle        = null ;
    var newEllipse       = null ;
    var newTriangle      = null ;
    var newRectangle     = null ;
    var newSquare        = null ;
    let stage, transformer      ; 

    function getColorFromSpan(clickedSpan) {
        var color = window.getComputedStyle(clickedSpan).backgroundColor ;
        return color ;
    }

    export default {
        name    : 'SideBar',

        data() {
            return {
                file: ""
            }
        },
            
        methods : {
            
            redo : async function (){
                
                //get history from backend
                const temp = await fetch("http://localhost:8080/function/redo");
                //get array of objects of r=the desired state
                const desiredState = await temp.json();

                this.loadShapes(desiredState)

            },

            undo : async function (){
                
                //get history from backend
                const temp = await fetch("http://localhost:8080/function/undo");
                //get array of objects of r=the desired state
                const desiredState = await temp.json();

                this.loadShapes(desiredState)

            },

            async saveData(e){
                
                e.preventDefault();

                const userInfo = document.querySelector(".saveForm");
                let formData = new FormData(userInfo);


                var object = {};
                formData.forEach((value, key) => {

                    if( key === "JSON" )
                        object["format"] = 1
                    else if( key === "XML" )
                        object["format"] = 2
                    else if( key === "BOTH" )
                        object["format"] = 3
                    else{

                        let loc = value.substring(1, value.length-1 )

                        if( loc.includes("\\Users") )
                            
                            object[key] = loc

                    }

                });

                var json = JSON.stringify(object);
                
                if( formData.get("saveLoc") ){
                    await fetch( 'http://localhost:8080/function/save', {
                        method: 'post',
                        headers: {
                            'Content-type': "application/json; charset=UTF-8"
                        },
                        body: json,
                    });
                }
            
            },

            async loadData(){
                
                const result = await fetch('http://localhost:8080/function/load', {
                    method: 'post',
                    headers: {
                        'Contect-type': 'application/json; charset=UTF-8'
                    },
                    body: this.file
                });
                
                // console.log( result )

                const desiredState = await result.json();

                // console.log(paint)

                this.loadShapes(desiredState)

            },


            loadShapes(desiredState){

                stage = new Konva.Stage({
                    container : 'container',
                    width     : window.innerWidth,
                    height    : window.innerHeight,
                }) ;

                stage.add(layer) ;

                for(let i=0;i<len(desiredState);i++){

                    let currentShape = desiredState[i];

                    if ( currentShape["shape"] === "rectangle" ){
                        newRectangle   = new Konva.Rect({
                            x            : currentShape["x"],
                            y            : currentShape["y"],
                            width        : currentShape["width"],
                            height       : currentShape["height"],
                            fill         : currentShape["fill"],
                            stroke       : currentShape["stroke"],
                            strokeWidth  : 2,
                            id           : currentShape["id"]
                        }) ;
                        layer.add(newRectangle ) ;
                        
                        let selectedColorSpan = null;

                        stage.on('mousedown', function () {
                            if(newRectangle){
                                newRectangle.on('transformend', () => {

                                    const updatedWidth  = newRectangle.width()  * newRectangle.scaleX() ;
                                    const updatedHeight = newRectangle.height() * newRectangle.scaleY() ;

                                    const updatedRectangleData = {
                                        shape        : 'rectangle',
                                        x            : newRectangle.position().x,
                                        y            : newRectangle.position().y,
                                        width        : updatedWidth,
                                        height       : updatedHeight,
                                        fill         : newRectangle.fill(),
                                        stroke       : 'black',
                                        strokeWidth  : 2,
                                        id           : newRectangle.id()
                                    } ;

                                    fetch('http://localhost:8080/function', {
                                        method: 'POST',
                                        headers: {
                                            'Content-Type': 'application/json',
                                        },
                                        body: JSON.stringify(updatedRectangleData),
                                    }) ;

                                }) ;
                            }
                        })

                        var colorSpans = document.querySelectorAll('.color-span') ;

                        colorSpans.forEach((span) => {
                            span.addEventListener('click', () => {
                                selectedColorSpan = span ;
                                this.changeColor(newRectangle, selectedColorSpan, layer) ;

                                if (newTriangle){
                                
                                    const updatedWidth  = newRectangle.width()  * newRectangle.scaleX() ;
                                    const updatedHeight = newRectangle.height() * newRectangle.scaleY() ;

                                    const updatedRectangleData = {
                                        shape        : 'rectangle',
                                        x            : newRectangle.position().x,
                                        y            : newRectangle.position().y,
                                        width        : updatedWidth,
                                        height       : updatedHeight,
                                        fill         : newRectangle.fill(),
                                        stroke       : 'black',
                                        strokeWidth  : 2,
                                        id           : newRectangle.id()
                                    } ;

                                    fetch('http://localhost:8080/', {
                                        method: 'POST',
                                        headers: {
                                            'Content-Type': 'application/json',
                                        },
                                        body: JSON.stringify(updatedRectangleData),
                                    }) ;

                                }    

                            }) ; 
                                
                        }) ;

                    } 
                    else if (  currentShape["shape"] === "circle" ){
                        newCircle = new Konva.Circle({
                            x           : currentShape["x"],
                            y           : currentShape["y"],
                            radius      : currentShape["radius"],
                            fill        : currentShape["fill"],
                            stroke      : currentShape["stroke"],
                            strokeWidth : 2,
                            id           : currentShape["id"]
                        }) ;
                        layer.add(newCircle) ;


                        stage.on('mousedown', function () {
                            if(newCircle){

                                newCircle.on('transformend', () => {
                                    
                                    const updatedRadius = newCircle.radius() * newCircle.scaleX() ;

                                    const updatedCircleData = {
                                        shape       : 'circle',
                                        x           : newCircle.position().x,
                                        y           : newCircle.position().y,
                                        radius      : updatedRadius,
                                        fill        : newCircle.fill(),
                                        stroke      : 'black',
                                        strokeWidth : 2,
                                        id           : newCircle.id()
                                    } ;

                                    fetch('http://localhost:8080/function/change/properties', {
                                        method  : 'POST',
                                        headers : {
                                            'Content-Type': 'application/json',
                                        },
                                        body: JSON.stringify(updatedCircleData),
                                    }) ;
                                
                                }) ;    
                            }
                        })
                        
                        var selectedColorSpan = null ;

                        var colorSpans = document.querySelectorAll('.color-span') ;

                        colorSpans.forEach((span) => {
                            span.addEventListener('click', () => {
                                selectedColorSpan = span ;
                                this.changeColor(newCircle, selectedColorSpan, layer) ;
                                
                                if (newCircle){

                                    const updatedRadius = newCircle.radius() * newCircle.scaleX() ;

                                    const updatedCircleData = {
                                        shape       : 'circle',
                                        x           : newCircle.position().x,
                                        y           : newCircle.position().y,
                                        radius      : updatedRadius,
                                        fill        : newCircle.fill(),
                                        stroke      : 'black',
                                        strokeWidth : 2,
                                        id           : newRectangle.id()
                                    } ;

                                    fetch('http://localhost:8080/function/change/fill', {
                                        method  : 'POST',
                                        headers : {
                                            'Content-Type': 'application/json',
                                        },
                                        body: JSON.stringify(updatedCircleData),
                                    }) ;

                                }

                            }) ; 

                        }) ;

                        

                    } 
                    else if (  currentShape["shape"] === "ellipse" ){
                        newEllipse   = new Konva.Ellipse({
                            x           : currentShape["x"],
                            y           : currentShape["y"],
                            radiusX      : currentShape["radiusX"],
                            radiusY      : currentShape["radiusY"],
                            fill        : currentShape["fill"],
                            stroke      : currentShape["stroke"],
                            strokeWidth : 2,
                            id           : currentShape["id"]
                        }) ;
                        layer.add(newEllipse) ;

                        var selectedColorSpan = null ;
                        
                        stage.on('mousedown', function () {

                            if (newEllipse){

                                newEllipse.on('transformend', () => {

                                    const updatedRadiusX = newEllipse.radiusX() * newEllipse.scaleX() ;
                                    const updatedRadiusY = newEllipse.radiusY() * newEllipse.scaleY() ;

                                    const updatedEllipseData = {
                                        shape       : 'ellipse',
                                        x           : newEllipse.position().x,
                                        y           : newEllipse.position().y,
                                        radiusX     : updatedRadiusX,
                                        radiusY     : updatedRadiusY,
                                        fill        : newEllipse.fill(),
                                        stroke      : 'black',
                                        strokeWidth : 2,
                                        id           : newEllipse.id()
                                    };

                                    fetch('http://localhost:8080/', {
                                        method: 'POST',
                                        headers: {
                                            'Content-Type': 'application/json',
                                        },
                                        body: JSON.stringify(updatedEllipseData),
                                    }) ;

                                }) ;

                            }
                        })

                        var colorSpans = document.querySelectorAll('.color-span') ;

                        colorSpans.forEach((span) => {
                            span.addEventListener('click', () => {
                                selectedColorSpan = span ;
                                this.changeColor(newEllipse, selectedColorSpan, layer) ;
                                
                                if (newEllipse){

                                    const updatedRadiusX = newEllipse.radiusX() * newEllipse.scaleX() ;
                                    const updatedRadiusY = newEllipse.radiusY() * newEllipse.scaleY() ;

                                    const updatedEllipseData = {
                                        shape       : 'ellipse',
                                        x           : newEllipse.position().x,
                                        y           : newEllipse.position().y,
                                        radiusX     : updatedRadiusX,
                                        radiusY     : updatedRadiusY,
                                        fill        : newEllipse.fill(),
                                        stroke      : 'black',
                                        strokeWidth : 2,
                                        id           : newEllipse.id()
                                    };

                                    fetch('http://localhost:8080/', {
                                        method: 'POST',
                                        headers: {
                                            'Content-Type': 'application/json',
                                        },
                                        body: JSON.stringify(updatedEllipseData),
                                    }) ;

                                }  
                                    
                            }) ; 

                        }) ;
                    } 
                    else if (  currentShape["shape"] === "line" ){
                        newLine = new Konva.Line({
                            points      : currentShape["points"],
                            closed      : currentShape["closed"],
                            stroke      : 'black',
                            strokeWidth : 5,
                            id          : currentShape["id"]
                        }); 
                        layer.add(newLine) ;
                    }	
                    else if (  currentShape["shape"] === "triangle" ){
                        newTriangle = new Konva.Line({
                            points      : currentShape["points"],
                            closed      : currentShape["closed"],
                            fill        : currentShape["fill"],
                            stroke      : currentShape["stroke"],
                            strokeWidth : currentShape["strokeWidth"],
                            id          : currentShape["id"]
                        }); 
                        layer.add(newLine) ;

                        var selectedColorSpan = null ;

                        stage.on('mousedown', function () {

                            if (newTriangle){    

                                newTriangle.on('transformend', () => {

                                    const scaleX = newTriangle.scaleX() ;
                                    const scaleY = newTriangle.scaleY() ;

                                    const originalPoints = [
                                        newTriangle.points()[0],
                                        newTriangle.points()[1],
                                        newTriangle.points()[2],
                                        newTriangle.points()[3],
                                        newTriangle.points()[4],
                                        newTriangle.points()[5]
                                    ] ;

                                    const updatedPoints = originalPoints.map((point, index) => index % 2 === 0 ? point * scaleX : point * scaleY) ;

                                        const updatedTriangleData = {
                                            shape       : 'triangle',
                                            points      : updatedPoints,                                
                                            closed      : true,
                                            fill        : newTriangle.fill(),
                                            stroke      : 'black',
                                            strokeWidth : 2,
                                            id           : newTriangle.id()
                                        } ;

                                        fetch('http://localhost:8080/', {
                                            method: 'POST',
                                            headers: {
                                                'Content-Type': 'application/json',
                                            },
                                            body: JSON.stringify(updatedTriangleData),
                                        }) ;
                                
                                }) ;
                            
                            } 

                        }) ;

                        var colorSpans = document.querySelectorAll('.color-span') ;

                        colorSpans.forEach((span) => {
                            span.addEventListener('click', () => {
                                selectedColorSpan = span ;
                                this.changeColor(newTriangle, selectedColorSpan, layer) ;

                                if(newTriangle){

                                    const scaleX = newTriangle.scaleX() ;
                                    const scaleY = newTriangle.scaleY() ;

                                    const originalPoints = [
                                        newTriangle.points()[0],
                                        newTriangle.points()[1],
                                        newTriangle.points()[2],
                                        newTriangle.points()[3],
                                        newTriangle.points()[4],
                                        newTriangle.points()[5]
                                    ] ;

                                    const updatedPoints = originalPoints.map((point, index) => index % 2 === 0 ? point * scaleX : point * scaleY) ;

                                    const updatedTriangleData = {
                                        shape       : 'triangle',
                                        points      : updatedPoints,                                
                                        closed      : true,
                                        fill        : newTriangle.fill(),
                                        stroke      : 'black',
                                        strokeWidth : 2,
                                        id           : newTriangle.id()
                                    } ;

                                    fetch('http://localhost:8080/', {
                                        method: 'POST',
                                        headers: {
                                            'Content-Type': 'application/json',
                                        },
                                        body: JSON.stringify(updatedTriangleData),
                                    }) ;

                                }    

                            }) ;
                            
                        }) ;

                        
                    }	
                    else if (  currentShape["shape"] === "square" ){
                        newSquare = new Konva.Line({
                            x            : currentShape["x"],
                            y            : currentShape["y"],
                            width        : currentShape["width"],
                            height       : currentShape["height"],
                            fill         : currentShape["fill"],
                            stroke       : currentShape["stroke"],
                            strokeWidth  : 2,
                            id           : currentShape["id"]
                        }); 
                        layer.add(newLine) ;

                        stage.on('mousedown', function () {   
                            if (newSquare){

                                newSquare.on('transformend', () => {

                                    const updatedLength  = newSquare.width() * newSquare.scaleX() ;
                                    
                                    const updatedSquareData = {
                                        shape        : 'square',
                                        x            : newSquare.position().x,
                                        y            : newSquare.position().y,
                                        width        : updatedLength,
                                        height       : updatedLength,
                                        fill         : newSquare.fill(),
                                        stroke       : 'black',
                                        strokeWidth  : 2,
                                        id           : newSquare.id()
                                    } ;

                                    fetch('http://localhost:8080/', {
                                        method: 'POST',
                                        headers: {
                                            'Content-Type': 'application/json',
                                        },
                                        body: JSON.stringify(updatedSquareData),
                                    }) ;

                                }) ;

                            }    

                        }) ;

                        var colorSpans = document.querySelectorAll('.color-span') ;

                        colorSpans.forEach((span) => {
                        span.addEventListener('click', () => {
                        selectedColorSpan = span ;
                        this.changeColor(newSquare, selectedColorSpan, layer) ;

                        if (newSquare){

                            const updatedLength  = newSquare.width() * newSquare.scaleX() ;
                            
                            const updatedSquareData = {
                                shape        : 'square',
                                x            : newSquare.position().x,
                                y            : newSquare.position().y,
                                width        : updatedLength,
                                height       : updatedLength,
                                fill         : newSquare.fill(),
                                stroke       : 'black',
                                strokeWidth  : 2,
                                id           : newSquare.id()
                            } ;

                            fetch('http://localhost:8080/', {
                                method: 'POST',
                                headers: {
                                    'Content-Type': 'application/json',
                                },
                                body: JSON.stringify(updatedSquareData),
                            }) ;

                        }    

                        }) ; 

                        }) 
                    }		
                }

                    layer.draw() ;
                
            },

            move: function () {
                var stage = new Konva.Stage({
                    container: 'container',
                    width: window.innerWidth,
                    height: window.innerHeight,
                });

                stage.add(layer);

                stage.on('click', function (e) {
                    var clickedShape = e.target;

                    if (!(clickedShape instanceof Konva.Shape)) {
                        console.log('Clicked on an unknown shape');
                        return;
                    }

                    clickedShape.draggable(!clickedShape.draggable());

                    if (clickedShape instanceof Konva.Line) {
                        clickedShape.on('click', () => {
                            clickedShape.draggable(!clickedShape.draggable());
                            layer.draw();
                        });
                    }
                });
            },

            deleteShape : function (){

                stage = new Konva.Stage({
                    container : 'container',
                    width     : window.innerWidth,
                    height    : window.innerHeight,
                }) ;

                stage.add(layer) ;

                stage.on('click', function (e) {
                    
                    var clickedShape = e.target ;
                    
                    if (clickedShape instanceof Konva.Rect || clickedShape instanceof Konva.Circle || clickedShape instanceof Konva.Line || clickedShape instanceof Konva.Ellipse ) {
                        clickedShape.remove() ;
                        layer.draw() ;
                    } 
                    else {
                        console.log('Clicked on an unknown shape to be deleted') ;
                    }
                    
                }) ;

            },

            copySelectedShape: function () {
                var stage = new Konva.Stage({
                    container : 'container',
                    width     : window.innerWidth,
                    height    : window.innerHeight,
                }) ;

                stage.add(layer) ;

                var clickedShape = null ;
                var newShape     = null ;

                stage.on('click', function (e) {
                    clickedShape = e.target ;

                    if (!(clickedShape instanceof Konva.Shape)) {
                        console.log('Clicked on an unknown shape to be copied');
                        return ;
                    }

                    if (
                        clickedShape instanceof Konva.Rect ||
                        clickedShape instanceof Konva.Circle ||
                        clickedShape instanceof Konva.Ellipse ||
                        (clickedShape instanceof Konva.Line && clickedShape.points.length === 4)
                    ) 
                    {
                        newShape = clickedShape.clone({ x: clickedShape.x(), y: clickedShape.y() });
                    } 
                    else if (clickedShape instanceof Konva.Line) {
                        var points = clickedShape.points().slice() ;
                        newShape   = new Konva.Line({
                            points      : [points[0]+20, points[1]+50 ,points[2]+20, points[3]+50] ,
                            closed      : true, 
                            stroke      : clickedShape.stroke(),
                            strokeWidth : clickedShape.strokeWidth(),
                        }) ;
                        layer.add(newShape) ;
                        layer.draw() ;
                        return ;
                    } 
                    else {
                        console.log('Clicked on an unknown shape to be copied') ;
                        return ;
                    }

                    var pointerPos = stage.getPointerPosition() ;
                    newShape.x(pointerPos.x) ;
                    newShape.y(pointerPos.y) ;
                    layer.add(newShape) ;
                    layer.draw() ;
                }) ;
            },


            resize : function() {

                stage = new Konva.Stage({
                    container: 'container',
                    width: window.innerWidth,
                    height: window.innerHeight,
                });

                stage.add(layer);

                transformer = new Konva.Transformer({
                    enabledAnchors: ['top-right', 'top-left', 'bottom-right', 'bottom-left'],
                    rotateEnabled: false
                });
                
                layer.add(transformer);

                stage.draw();

                stage.on('click', (e) => this.selectShape(e.target)) ;

            },

            selectShape(shape) {
                if (shape) {
                    transformer.attachTo(shape);

                    const shapeType = shape.getClassName() ;

                    switch (shapeType) {
                        case 'Rect'  :
                        case 'Square':

                            transformer.nodes([shape]) ;
                            break ;

                        case 'Circle'  :
                        case 'Ellipse' :
  
                        transformer.nodes([shape]) ;
                            break ;
                        
                        case 'Line':
                            
                            transformer.nodes([shape]) ;
                            break ;
                        case 'RegularPolygon':
                            
                            transformer.nodes([shape]) ;
                            break ;

                        default :
                            break ;

                    }

                    layer.draw() ;
                }
            },

            deselectShape() {
            
                transformer.detach() ;
                layer.draw() ;
            },
                
            changeColor(newShape, selectedColorSpan, layer) {
                if (newShape && selectedColorSpan) {
                    var color = getColorFromSpan(selectedColorSpan) ;
                    newShape.fill(color) ;
                    layer.draw() ;
                }
            },

            drawLine: function () {

                var width  = window.innerWidth  ;
                var height = window.innerHeight ;

                let line = document.querySelector(".line") ;

                var stage = new Konva.Stage({
                    container : 'container',
                    width     : width,
                    height    : height,
                }) ;

                line.style.left = "-11%" ;

                stage.add(layer) ;

                var point1, point2 ;

                stage.on('mousedown', function () {

                    if (!point1) {
                        point1 = stage.getPointerPosition() ;
                    } 
                    else {
                        point2 = stage.getPointerPosition() ;

                        newLine = new Konva.Line({
                            points      : [point1.x, point1.y, point2.x, point2.y],
                            stroke      : 'black',
                            strokeWidth : 5,
                        });

                        layer.add(newLine) ;
                        
                        if (newLine){

                            const lineData = {
                                shape       : "line",
                                points      : [point1.x, point1.y, point2.x, point2.y],
                                stroke      : 'black',
                                strokeWidth : 5, 
                            } ;
                            
                            fetch('http://localhost:8080/', {
                                method: 'POST',
                                headers: {
                                    'Content-Type': 'application/json',
                                },
                                body: JSON.stringify(lineData),
                            })
                        }

                        point1 = null ;
                        point2 = null ;
                    
                    }

                }) ;
        
            },

            drawCircle() {
                
                var width  = window.innerWidth;
                var height = window.innerHeight;

                let circle = document.querySelector(".circle") ;
                let radius = document.querySelector("#radius") ;

                var stage = new Konva.Stage({
                    container : 'container',
                    width     : width,
                    height    : height,
                }) ;

                circle.style.left = "-11%" ;

                radius = parseFloat(radius.value);

                stage.add(layer) ;

                var selectedColorSpan = null ;

                newEllipse   = null ;
                newTriangle  = null ;
                newRectangle = null ;
                newSquare    = null ;

                stage.on('mousedown', () => {
                    var pos = stage.getPointerPosition();
                    newCircle = new Konva.Circle({
                        x           : pos.x,
                        y           : pos.y,
                        radius      : radius,
                        fill        : 'white',
                        stroke      : 'black',
                        strokeWidth : 2,
                    }) ;

                    layer.add(newCircle) ;

                    if (newCircle){
                        
                        const CircleData = {
                            shape       : 'circle',
                            x           : pos.x,
                            y           : pos.y,
                            radius      : radius,
                            fill        : 'white',
                            stroke      : 'black',
                            strokeWidth : 2,
                        } ;
                            
                        fetch('http://localhost:8080/', {
                            method: 'POST',
                            headers: {
                                'Content-Type': 'application/json',
                            },
                            body: JSON.stringify(CircleData),
                        })
                        
                        newCircle.on('transformend', () => {
                            
                            const updatedRadius = newCircle.radius() * newCircle.scaleX() ;

                            const updatedCircleData = {
                                shape       : 'circle',
                                x           : newCircle.position().x,
                                y           : newCircle.position().y,
                                radius      : updatedRadius,
                                fill        : newCircle.fill(),
                                stroke      : 'black',
                                strokeWidth : 2,
                            } ;

                            fetch('http://localhost:8080/', {
                                method  : 'POST',
                                headers : {
                                    'Content-Type': 'application/json',
                                },
                                body: JSON.stringify(updatedCircleData),
                            }) ;
                        
                        }) ;    
                    }
    
                }) ;

                var colorSpans = document.querySelectorAll('.color-span') ;

                colorSpans.forEach((span) => {
                    span.addEventListener('click', () => {
                        selectedColorSpan = span ;
                        this.changeColor(newCircle, selectedColorSpan, layer) ;
                        
                        if (newCircle){

                            const updatedRadius = newCircle.radius() * newCircle.scaleX() ;

                            const updatedCircleData = {
                                shape       : 'circle',
                                x           : newCircle.position().x,
                                y           : newCircle.position().y,
                                radius      : updatedRadius,
                                fill        : newCircle.fill(),
                                stroke      : 'black',
                                strokeWidth : 2,
                            } ;

                            fetch('http://localhost:8080/', {
                                method  : 'POST',
                                headers : {
                                    'Content-Type': 'application/json',
                                },
                                body: JSON.stringify(updatedCircleData),
                            }) ;

                        }

                    }) ; 

                }) ;

            },

            drawEllipse : function (){

                var width  = window.innerWidth  ;
                var height = window.innerHeight ;

                let ellipse = document.querySelector(".ellipse") ;
                let radiusX = document.querySelector("#radiusX") ;
                let radiusY = document.querySelector("#radiusY") ;

                var stage     = new Konva.Stage({
                    container : 'container',
                    width     : width,
                    height    : height,
                }) ;

                ellipse.style.left = "-11%"  ;

                radiusX = parseFloat(radiusX.value) ;
                radiusY = parseFloat(radiusY.value) ; 

                stage.add(layer) ;

                var selectedColorSpan = null ;

                newCircle    = null ;
                newTriangle  = null ;
                newRectangle = null ;
                newSquare    = null ;

                stage.on('mousedown', function () {
                    var pos = stage.getPointerPosition() ;
                    newEllipse   = new Konva.Ellipse({
                        x            : pos.x,
                        y            : pos.y,
                        radiusX      : radiusX,
                        radiusY      : radiusY,
                        fill         : 'white',
                        stroke       : 'black',
                        strokeWidth  : 2,
                    }) ;

                    layer.add(newEllipse) ;

                    if (newEllipse){

                        const EllipseData = {
                            shape       : 'ellipse',
                            x           : pos.x,
                            y           : pos.y,
                            radiusX     : radiusX,
                            radiusY     : radiusY,
                            fill        : 'white',
                            stroke      : 'black',
                            strokeWidth : 2,
                        } ;
                            
                        fetch('http://localhost:8080/', {
                            method: 'POST',
                            headers: {
                                'Content-Type': 'application/json',
                            },
                            body: JSON.stringify(EllipseData),
                        })

                        
                        newEllipse.on('transformend', () => {

                            const updatedRadiusX = newEllipse.radiusX() * newEllipse.scaleX() ;
                            const updatedRadiusY = newEllipse.radiusY() * newEllipse.scaleY() ;

                            const updatedEllipseData = {
                                shape       : 'ellipse',
                                x           : newEllipse.position().x,
                                y           : newEllipse.position().y,
                                radiusX     : updatedRadiusX,
                                radiusY     : updatedRadiusY,
                                fill        : newEllipse.fill(),
                                stroke      : 'black',
                                strokeWidth : 2,
                            };

                            fetch('http://localhost:8080/', {
                                method: 'POST',
                                headers: {
                                    'Content-Type': 'application/json',
                                },
                                body: JSON.stringify(updatedEllipseData),
                            }) ;

                        }) ;

                    }

                }) ;
                                
                var colorSpans = document.querySelectorAll('.color-span') ;

                colorSpans.forEach((span) => {
                    span.addEventListener('click', () => {
                        selectedColorSpan = span ;
                        this.changeColor(newEllipse, selectedColorSpan, layer) ;
                        
                        if (newEllipse){

                            const updatedRadiusX = newEllipse.radiusX() * newEllipse.scaleX() ;
                            const updatedRadiusY = newEllipse.radiusY() * newEllipse.scaleY() ;

                            const updatedEllipseData = {
                                shape       : 'ellipse',
                                x           : newEllipse.position().x,
                                y           : newEllipse.position().y,
                                radiusX     : updatedRadiusX,
                                radiusY     : updatedRadiusY,
                                fill        : newEllipse.fill(),
                                stroke      : 'black',
                                strokeWidth : 2,
                            };

                            fetch('http://localhost:8080/', {
                                method: 'POST',
                                headers: {
                                    'Content-Type': 'application/json',
                                },
                                body: JSON.stringify(updatedEllipseData),
                            }) ;

                        }  
                            
                    }) ; 

                }) ;

            },

            drawTriangle : function(){

                var width  = window.innerWidth  ;
                var height = window.innerHeight ;

                let triangle = document.querySelector(".triangle") ;

                var stage = new Konva.Stage({
                    container : 'container',
                    width     : width,
                    height    : height,
                }) ;

                triangle.style.left = "-11%" ;

                stage.add(layer) ;

                var point1, point2, point3 ;

                var selectedColorSpan = null ;

                newCircle    = null ;
                newEllipse   = null ;
                newRectangle = null ;
                newSquare    = null ;

                stage.on('mousedown', function () {

                    if (!point1) 
                        point1 = stage.getPointerPosition() ;
                    
                    else if (!point2)
                        point2 = stage.getPointerPosition() ;

                    else {
                        point3 = stage.getPointerPosition() ;

                            newTriangle = new Konva.Line({
                                points      : [point1.x, point1.y, point2.x, point2.y, point3.x, point3.y],
                                closed      : true,
                                stroke      : 'black',
                                strokeWidth : 2,
                            });  

                        layer.add(newTriangle) ;

                        if (newTriangle){    

                            const TriangleData = {
                                shape       : 'triangle',
                                points      : [point1.x, point1.y, point2.x, point2.y, point3.x, point3.y],
                                closed      : true,
                                fill        : 'white',
                                stroke      : 'black',
                                strokeWidth : 2,
                            } ;

                            fetch('http://localhost:8080/', {
                                method: 'POST',
                                headers: {
                                    'Content-Type': 'application/json',
                                },
                                body: JSON.stringify(TriangleData),
                            })

                            
                            newTriangle.on('transformend', () => {

                                const scaleX = newTriangle.scaleX() ;
                                const scaleY = newTriangle.scaleY() ;

                                const originalPoints = [
                                    newTriangle.points()[0],
                                    newTriangle.points()[1],
                                    newTriangle.points()[2],
                                    newTriangle.points()[3],
                                    newTriangle.points()[4],
                                    newTriangle.points()[5]
                                ] ;

                                const updatedPoints = originalPoints.map((point, index) => index % 2 === 0 ? point * scaleX : point * scaleY) ;

                                    const updatedTriangleData = {
                                        shape       : 'triangle',
                                        points      : updatedPoints,                                
                                        closed      : true,
                                        fill        : newTriangle.fill(),
                                        stroke      : 'black',
                                        strokeWidth : 2,
                                    } ;

                                    fetch('http://localhost:8080/', {
                                        method: 'POST',
                                        headers: {
                                            'Content-Type': 'application/json',
                                        },
                                        body: JSON.stringify(updatedTriangleData),
                                    }) ;
                            
                            }) ;
                        
                        }   

                        point1 = null ;
                        point2 = null ;
                        point3 = null ;

                    }

                }) ;

                var colorSpans = document.querySelectorAll('.color-span') ;

                colorSpans.forEach((span) => {
                    span.addEventListener('click', () => {
                        selectedColorSpan = span ;
                        this.changeColor(newTriangle, selectedColorSpan, layer) ;

                        if(newTriangle){

                            const scaleX = newTriangle.scaleX() ;
                            const scaleY = newTriangle.scaleY() ;

                            const originalPoints = [
                                newTriangle.points()[0],
                                newTriangle.points()[1],
                                newTriangle.points()[2],
                                newTriangle.points()[3],
                                newTriangle.points()[4],
                                newTriangle.points()[5]
                            ] ;

                            const updatedPoints = originalPoints.map((point, index) => index % 2 === 0 ? point * scaleX : point * scaleY) ;

                            const updatedTriangleData = {
                                shape       : 'triangle',
                                points      : updatedPoints,                                
                                closed      : true,
                                fill        : newTriangle.fill(),
                                stroke      : 'black',
                                strokeWidth : 2,
                            } ;

                            fetch('http://localhost:8080/', {
                                method: 'POST',
                                headers: {
                                    'Content-Type': 'application/json',
                                },
                                body: JSON.stringify(updatedTriangleData),
                            }) ;

                        }    

                    }) ;
                     
                }) ;

                point1 = null ;
                point2 = null ;
                point3 = null ;

            },

            drawRectangle : function(){

                var Width  = window.innerWidth  ;
                var Height = window.innerHeight ;

                let rectangle = document.querySelector(".rectangle") ;
                let width     = document.querySelector("#width")     ;
                let height    = document.querySelector("#height")    ;

                var stage     = new Konva.Stage({
                    container : 'container',
                    width     : Width,
                    height    : Height,
                }) ;

                rectangle.style.left = "-11%" ;

                width  = parseFloat(width.value)  ;
                height = parseFloat(height.value) ; 

                stage.add(layer) ;

                var selectedColorSpan = null ;

                newCircle    = null ;
                newEllipse   = null ;
                newTriangle  = null ;
                newSquare    = null ;

                stage.on('mousedown', function () {
                    var pos = stage.getPointerPosition() ;
                        newRectangle   = new Konva.Rect({
                        x            : pos.x,
                        y            : pos.y,
                        width        : width,
                        height       : height,
                        fill         : 'white',
                        stroke       : 'black',
                        strokeWidth  : 2,
                    }) ;

                    layer.add(newRectangle) ;

                    if (newRectangle){

                        const RectangleData = {
                            shape        : 'rectangle',
                            x            : pos.x,
                            y            : pos.y,
                            width        : width,
                            height       : height,
                            fill         : 'white',
                            stroke       : 'black',
                            strokeWidth  : 2,
                        } ;
                            
                        fetch('http://localhost:8080/', {
                            method: 'POST',
                            headers: {
                                'Content-Type': 'application/json',
                            },
                            body: JSON.stringify(RectangleData),
                        })

                        
                        newRectangle.on('transformend', () => {

                            const updatedWidth  = newRectangle.width()  * newRectangle.scaleX() ;
                            const updatedHeight = newRectangle.height() * newRectangle.scaleY() ;

                            const updatedRectangleData = {
                                shape        : 'rectangle',
                                x            : newRectangle.position().x,
                                y            : newRectangle.position().y,
                                width        : updatedWidth,
                                height       : updatedHeight,
                                fill         : newRectangle.fill(),
                                stroke       : 'black',
                                strokeWidth  : 2,
                            } ;

                            fetch('http://localhost:8080/', {
                                method: 'POST',
                                headers: {
                                    'Content-Type': 'application/json',
                                },
                                body: JSON.stringify(updatedRectangleData),
                            }) ;

                        }) ;

                    } 

                }) ;

                var colorSpans = document.querySelectorAll('.color-span') ;

                colorSpans.forEach((span) => {
                    span.addEventListener('click', () => {
                        selectedColorSpan = span ;
                        this.changeColor(newRectangle, selectedColorSpan, layer) ;

                        if (newTriangle){
                        
                            const updatedWidth  = newRectangle.width()  * newRectangle.scaleX() ;
                            const updatedHeight = newRectangle.height() * newRectangle.scaleY() ;

                            const updatedRectangleData = {
                                shape        : 'rectangle',
                                x            : newRectangle.position().x,
                                y            : newRectangle.position().y,
                                width        : updatedWidth,
                                height       : updatedHeight,
                                fill         : newRectangle.fill(),
                                stroke       : 'black',
                                strokeWidth  : 2,
                            } ;

                            fetch('http://localhost:8080/', {
                                method: 'POST',
                                headers: {
                                    'Content-Type': 'application/json',
                                },
                                body: JSON.stringify(updatedRectangleData),
                            }) ;

                        }    

                    }) ; 
                        
                }) ;

            },

            drawSquare : function(){

                var Width  = window.innerWidth  ;
                var Height = window.innerHeight ;

                let square = document.querySelector(".square") ;
                let length = document.querySelector("#length") ;
                
                var stage     = new Konva.Stage({
                    container : 'container',
                    width     : Width,
                    height    : Height,
                }) ;

                square.style.left = "-11%" ;

                length = parseFloat(length.value) ;
                
                stage.add(layer) ;

                var selectedColorSpan = null ;
                
                newCircle    = null ;
                newEllipse   = null ;
                newTriangle  = null ;
                newRectangle = null ;

                stage.on('mousedown', function () {
                    var pos = stage.getPointerPosition() ;
                        newSquare   = new Konva.Rect({
                        x            : pos.x,
                        y            : pos.y,
                        width        : length,
                        height       : length,
                        fill         : 'white',
                        stroke       : 'black',
                        strokeWidth  : 2,
                    }) ;

                    layer.add(newSquare) ;

                    if (newSquare){

                        const SquareData = {
                            shape        : 'square',
                            x            : pos.x,
                            y            : pos.y,
                            width        : length,
                            height       : length,
                            fill         : 'white',
                            stroke       : 'black',
                            strokeWidth  : 2,
                        } ;
                            
                        fetch('http://localhost:8080/', {
                            method: 'POST',
                            headers: {
                                'Content-Type': 'application/json',
                            },
                            body: JSON.stringify(SquareData),
                        })
                    
                        newSquare.on('transformend', () => {

                            const updatedLength  = newSquare.width() * newSquare.scaleX() ;
                            
                            const updatedSquareData = {
                                shape        : 'square',
                                x            : newSquare.position().x,
                                y            : newSquare.position().y,
                                width        : updatedLength,
                                height       : updatedLength,
                                fill         : newSquare.fill(),
                                stroke       : 'black',
                                strokeWidth  : 2,
                            } ;

                            fetch('http://localhost:8080/', {
                                method: 'POST',
                                headers: {
                                    'Content-Type': 'application/json',
                                },
                                body: JSON.stringify(updatedSquareData),
                            }) ;

                        }) ;

                    }    

                }) ;

                var colorSpans = document.querySelectorAll('.color-span') ;

                colorSpans.forEach((span) => {
                    span.addEventListener('click', () => {
                        selectedColorSpan = span ;
                        this.changeColor(newSquare, selectedColorSpan, layer) ;

                        if (newSquare){

                            const updatedLength  = newSquare.width() * newSquare.scaleX() ;
                            
                            const updatedSquareData = {
                                shape        : 'square',
                                x            : newSquare.position().x,
                                y            : newSquare.position().y,
                                width        : updatedLength,
                                height       : updatedLength,
                                fill         : newSquare.fill(),
                                stroke       : 'black',
                                strokeWidth  : 2,
                            } ;

                            fetch('http://localhost:8080/', {
                                method: 'POST',
                                headers: {
                                    'Content-Type': 'application/json',
                                },
                                body: JSON.stringify(updatedSquareData),
                            }) ;

                        }    

                    }) ; 

                }) 

            },
            
            showHideShapeBar : function (){
                let loadXML      = document.querySelector('.loadXML')      ;
                let loadJSON     = document.querySelector('.loadFile')     ;
                let saveXML      = document.querySelector('.saveXML')      ;
                let saveJSON     = document.querySelector('.saveJSON')     ;
                let colorPalette = document.querySelector('.colorPalette') ;
                let shapeBar     = document.querySelector('.shapeBar')     ;
                let line         = document.querySelector(".line")         ;
                let circle       = document.querySelector(".circle")       ;   
                let ellipse      = document.querySelector(".ellipse")      ;
                let triangle     = document.querySelector(".triangle")     ;
                let rectangle    = document.querySelector(".rectangle")    ;
                let square       = document.querySelector(".square")       ; 

                if (colorPalette.style.opacity === "1"){ 

                    colorPalette.style.opacity = "0" ;

                    if (loadXML.style.left === "5%" || saveXML.style.left === "5%"){ 

                        loadXML.style.left  = "-35%" ;
                        loadJSON.style.left = "-35%" ;

                        saveXML.style.left  = "-35%" ;
                        saveJSON.style.left = "-35%" ;

                        setTimeout(() => {
                            shapeBar.style.left = "5%" ;
                        }, 600) ;
                
                    }

                    else{
                        setTimeout(() => {
                            shapeBar.style.left = "5%"   ;
                        }, 500) ;
                    }

                }

                else if (loadXML.style.left === "5%" || saveXML.style.left === "5%"){ 

                    loadXML.style.left  = "-35%" ;
                    loadJSON.style.left = "-35%" ;

                    saveXML.style.left  = "-35%" ;
                    saveJSON.style.left = "-35%" ;

                    setTimeout(() => {
                        shapeBar.style.left = "5%" ;
                    }, 200) ;

                }
                
                else if (line.style.left === "12%"){

                    line.style.left = "-11%" ;

                    setTimeout(() => {
                        shapeBar.style.left = "-2%"   ;
                    }, 200) ;

                }

                else if (circle.style.left === "12%"){
                    circle.style.left = "-11%"

                    setTimeout(() => {
                        shapeBar.style.left = "-2%"   ;
                    }, 200) ;

                }

                else if (ellipse.style.left === "12%"){
                    ellipse.style.left = "-11%"

                    setTimeout(() => {
                        shapeBar.style.left = "-2%"   ;
                    }, 200) ;

                }

                else if (triangle.style.left === "12%"){
                    triangle.style.left = "-11%"

                    setTimeout(() => {
                        shapeBar.style.left = "-2%"   ;
                    }, 200) ;

                }

                else if (rectangle.style.left === "12%"){
                    rectangle.style.left = "-11%"

                    setTimeout(() => {
                        shapeBar.style.left = "-2%"   ;
                    }, 200) ;

                }

                else if (square.style.left === "12%"){
                    square.style.left = "-11%"

                    setTimeout(() => {
                        shapeBar.style.left = "-2%"   ;
                    }, 200) ;

                }

                else{
                    if (shapeBar.style.left === "5%")
                        shapeBar.style.left = "-2%" ;
                    else
                        shapeBar.style.left = "5%"   ;
                }

            },

            showHideColorPalette : function (){
                let colorPalette = document.querySelector('.colorPalette') ;
                let shapeBar     = document.querySelector('.shapeBar')     ;
                let line         = document.querySelector(".line")         ;
                let circle       = document.querySelector(".circle")       ;   
                let ellipse      = document.querySelector(".ellipse")      ;
                let triangle     = document.querySelector(".triangle")     ;
                let rectangle    = document.querySelector(".rectangle")    ;
                let square       = document.querySelector(".square")       ; 
                
                if (shapeBar.style.left === "5%"){

                    if (line.style.left === "12%"){
                    
                        line.style.left = "-11%" ;

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            colorPalette.style.opacity = "1" ;
                        }, 400) ;

                    }

                    else if (circle.style.left === "12%"){
                        circle.style.left = "-11%"

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            colorPalette.style.opacity = "1" ;
                        }, 400) ;

                    }

                    else if (ellipse.style.left === "12%"){
                        ellipse.style.left = "-11%"

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            colorPalette.style.opacity = "1" ;
                        }, 400) ;

                    }

                    else if (triangle.style.left === "12%"){
                        triangle.style.left = "-11%"

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            colorPalette.style.opacity = "1" ;
                        }, 400) ;


                    }

                    else if (rectangle.style.left === "12%"){
                        rectangle.style.left = "-11%"

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            colorPalette.style.opacity = "1" ;
                        }, 400) ;


                    }

                    else if (square.style.left === "12%"){
                        square.style.left = "-11%"

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            colorPalette.style.opacity = "1" ;
                        }, 400) ;


                    }

                    else{
                        
                        shapeBar.style.left = "-2%" ;
                    
                        setTimeout(() => {
                            colorPalette.style.opacity = "1" ;
                        }, 200) ;

                    }
                    
                }
                
                else{
                    if (colorPalette.style.opacity === "1") 
                        colorPalette.style.opacity = "0" ;
                    else 
                        colorPalette.style.opacity = "1" ;
                }
            
            },

            showHideLineOption : function(){
                let line      = document.querySelector(".line")      ;
                let circle    = document.querySelector(".circle")    ;
                let ellipse   = document.querySelector(".ellipse")   ;
                let triangle  = document.querySelector(".triangle")  ;
                let rectangle = document.querySelector(".rectangle") ;
                let square    = document.querySelector(".square")    ;
            
                if (circle.style.left === "12%"){
                    circle.style.left = "-11%" ;

                    setTimeout(() => {
                        line.style.left = "12%" ;
                    }, 200) ;

                }

                else if (ellipse.style.left === "12%"){
                    ellipse.style.left = "-11%" ;

                    setTimeout(() => {
                        line.style.left = "12%" ;
                    }, 200) ;

                }

                else if (triangle.style.left === "12%"){
                    triangle.style.left = "-11%" ;

                    setTimeout(() => {
                        line.style.left = "12%" ;
                    }, 200) ;

                }

                else if (rectangle.style.left === "12%"){
                    rectangle.style.left = "-11%" ;

                    setTimeout(() => {
                        line.style.left = "12%" ;
                    }, 200) ;

                }

                else if (square.style.left === "12%"){
                    square.style.left = "-11%" ;

                    setTimeout(() => {
                        line.style.left = "12%" ;
                    }, 200) ;

                }

                else {

                    if (line.style.left === "12%")
                        line.style.left = "-11%" ;
                    else
                        line.style.left = "12%"

                }
            
            },

            showHideCircleOption : function(){
                let line      = document.querySelector(".line")      ;
                let circle    = document.querySelector(".circle")    ;
                let ellipse   = document.querySelector(".ellipse")   ;
                let triangle  = document.querySelector(".triangle")  ;
                let rectangle = document.querySelector(".rectangle") ;
                let square    = document.querySelector(".square")    ;
            
                if (line.style.left === "12%"){
                    line.style.left = "-11%" ;

                    setTimeout(() => {
                        circle.style.left = "12%" ;
                    }, 200) ;

                }

                else if (ellipse.style.left === "12%"){
                    ellipse.style.left = "-11%" ;

                    setTimeout(() => {
                        circle.style.left = "12%" ;
                    }, 200) ;

                }

                else if (triangle.style.left === "12%"){
                    triangle.style.left = "-11%" ;

                    setTimeout(() => {
                        circle.style.left = "12%" ;
                    }, 200) ;

                }

                else if (rectangle.style.left === "12%"){
                    rectangle.style.left = "-11%" ;

                    setTimeout(() => {
                        circle.style.left = "12%" ;
                    }, 200) ;

                }

                else if (square.style.left === "12%"){
                    square.style.left = "-11%" ;

                    setTimeout(() => {
                        circle.style.left = "12%" ;
                    }, 200) ;

                }

                else {

                    if (circle.style.left === "12%")
                        circle.style.left = "-11%" ;
                    else
                        circle.style.left = "12%"  ;

                }
            
            },

            showHideEllipseOption : function(){
                let line      = document.querySelector(".line")      ;
                let circle    = document.querySelector(".circle")    ;
                let ellipse   = document.querySelector(".ellipse")   ;
                let triangle  = document.querySelector(".triangle")  ;
                let rectangle = document.querySelector(".rectangle") ;
                let square    = document.querySelector(".square")    ;
            
                if (line.style.left === "12%"){
                    line.style.left = "-11%" ;

                    setTimeout(() => {
                        ellipse.style.left = "12%" ;
                    }, 200) ;

                }

                else if (circle.style.left === "12%"){
                    circle.style.left = "-11%" ;

                    setTimeout(() => {
                        ellipse.style.left = "12%" ;
                    }, 200) ;

                }

                else if (triangle.style.left === "12%"){
                    triangle.style.left = "-11%" ;

                    setTimeout(() => {
                        ellipse.style.left = "12%" ;
                    }, 200) ;

                }

                else if (rectangle.style.left === "12%"){
                    rectangle.style.left = "-11%" ;

                    setTimeout(() => {
                        ellipse.style.left = "12%" ;
                    }, 200) ;

                }

                else if (square.style.left === "12%"){
                    square.style.left = "-11%" ;

                    setTimeout(() => {
                        ellipse.style.left = "12%" ;
                    }, 200) ;

                }

                else {

                    if (ellipse.style.left === "12%")
                        ellipse.style.left = "-11%" ;
                    else
                        ellipse.style.left = "12%"  ;

                }
            
            },

            showHideTriangleOption : function(){
                let line      = document.querySelector(".line")      ;
                let circle    = document.querySelector(".circle")    ;
                let ellipse   = document.querySelector(".ellipse")   ;
                let triangle  = document.querySelector(".triangle")  ;
                let rectangle = document.querySelector(".rectangle") ;
                let square    = document.querySelector(".square")    ;
            
                if (line.style.left === "12%"){
                    line.style.left = "-11%" ;

                    setTimeout(() => {
                        triangle.style.left = "12%" ;
                    }, 200) ;

                }

                else if (circle.style.left === "12%"){
                    circle.style.left = "-11%" ;

                    setTimeout(() => {
                        triangle.style.left = "12%" ;
                    }, 200) ;

                }

                else if (ellipse.style.left === "12%"){
                    ellipse.style.left = "-11%" ;

                    setTimeout(() => {
                        triangle.style.left = "12%" ;
                    }, 200) ;

                }

                else if (rectangle.style.left === "12%"){
                    rectangle.style.left = "-11%" ;

                    setTimeout(() => {
                        triangle.style.left = "12%" ;
                    }, 200) ;

                }

                else if (square.style.left === "12%"){
                    square.style.left = "-11%" ;

                    setTimeout(() => {
                        triangle.style.left = "12%" ;
                    }, 200) ;

                }

                else {

                    if (triangle.style.left === "12%")
                        triangle.style.left = "-11%" ;
                    else
                        triangle.style.left = "12%"  ;

                }
            
            },

            showHideSave : function(){

                let saveXML   = document.querySelector('.saveXML')   ;
                let saveJSON  = document.querySelector('.saveJSON')  ;
                let shapeBar  = document.querySelector('.shapeBar')  ;
                let line      = document.querySelector(".line")      ;
                let circle    = document.querySelector(".circle")    ;   
                let ellipse   = document.querySelector(".ellipse")   ;
                let triangle  = document.querySelector(".triangle")  ;
                let rectangle = document.querySelector(".rectangle") ;
                let square    = document.querySelector(".square")    ; 

                if (shapeBar.style.left === "5%"){

                    if (line.style.left === "12%"){
                    
                        line.style.left = "-11%" ;

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            saveXML.style.left  = "5%" ;
                            saveJSON.style.left = "5%" ;
                        }, 700) ;

                    }

                    else if (circle.style.left === "12%"){
                        circle.style.left = "-11%"

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            saveXML.style.left  = "5%" ;
                            saveJSON.style.left = "5%" ;
                        }, 700) ;

                    }

                    else if (ellipse.style.left === "12%"){
                        ellipse.style.left = "-11%"

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            saveXML.style.left  = "5%" ;
                            saveJSON.style.left = "5%" ;
                        }, 700) ;

                    }

                    else if (triangle.style.left === "12%"){
                        triangle.style.left = "-11%"

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            saveXML.style.left  = "5%" ;
                            saveJSON.style.left = "5%" ;
                        }, 700) ;


                    }

                    else if (rectangle.style.left === "12%"){
                        rectangle.style.left = "-11%"

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            saveXML.style.left  = "5%" ;
                            saveJSON.style.left = "5%" ;
                        }, 700) ;


                    }

                    else if (square.style.left === "12%"){
                        square.style.left = "-11%"

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            saveXML.style.left  = "5%" ;
                            saveJSON.style.left = "5%" ;
                        }, 700) ;


                    }

                    else{
                        
                        shapeBar.style.left = "-2%" ;
                    
                        setTimeout(() => {
                            saveXML.style.left  = "5%" ;
                            saveJSON.style.left = "5%" ;
                        }, 200) ;

                    }
                    
                }

                else{
                    if (saveXML.style.left === "5%" ){

                        saveXML.style.left  = "-35%" ;
                        saveJSON.style.left = "-35%" ;
                    } 
                    else{
                        saveXML.style.left  = "5%" ;
                        saveJSON.style.left = "5%" ;
                    }

                }

                },


            showHideLoad : function(){

                let loadXML   = document.querySelector('.loadXML')   ;
                let loadJSON  = document.querySelector('.loadJSON')  ;
                let shapeBar  = document.querySelector('.shapeBar')  ;
                let line      = document.querySelector(".line")      ;
                let circle    = document.querySelector(".circle")    ;   
                let ellipse   = document.querySelector(".ellipse")   ;
                let triangle  = document.querySelector(".triangle")  ;
                let rectangle = document.querySelector(".rectangle") ;
                let square    = document.querySelector(".square")    ; 
                
                if (shapeBar.style.left === "5%"){

                    if (line.style.left === "12%"){
                    
                        line.style.left = "-11%" ;

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            loadXML.style.left  = "5%" ;
                            loadJSON.style.left = "5%" ;
                        }, 700) ;

                    }

                    else if (circle.style.left === "12%"){
                        circle.style.left = "-11%"

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            loadXML.style.left  = "5%" ;
                            loadJSON.style.left = "5%" ;
                        }, 700) ;

                    }

                    else if (ellipse.style.left === "12%"){
                        ellipse.style.left = "-11%"

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            loadXML.style.left  = "5%" ;
                            loadJSON.style.left = "5%" ;
                        }, 700) ;

                    }

                    else if (triangle.style.left === "12%"){
                        triangle.style.left = "-11%"

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            loadXML.style.left  = "5%" ;
                            loadJSON.style.left = "5%" ;
                        }, 700) ;


                    }

                    else if (rectangle.style.left === "12%"){
                        rectangle.style.left = "-11%"

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            loadXML.style.left  = "5%" ;
                            loadJSON.style.left = "5%" ;
                        }, 700) ;


                    }

                    else if (square.style.left === "12%"){
                        square.style.left = "-11%"

                        setTimeout(() => {
                            shapeBar.style.left = "-2%"   ;
                        }, 200) ;

                        setTimeout(() => {
                            loadXML.style.left  = "5%" ;
                            loadJSON.style.left = "5%" ;
                        }, 700) ;

                    }

                    else{
                        
                        shapeBar.style.left = "-2%" ;
                    
                        setTimeout(() => {
                            loadXML.style.left  = "5%" ;
                            loadJSON.style.left = "5%" ;
                        }, 200) ;

                    }
                    
                }
                
                else{
                    if (loadXML.style.left === "5%" ){

                        loadXML.style.left  = "-35%" ;
                        loadJSON.style.left = "-35%" ;
                    } 
                    else{
                        loadXML.style.left  = "5%" ;
                        loadJSON.style.left = "5%" ;
                    }

                }

            },

            showHideRectangleOption : function(){
                let line      = document.querySelector(".line")      ;
                let circle    = document.querySelector(".circle")    ;
                let ellipse   = document.querySelector(".ellipse")   ;
                let triangle  = document.querySelector(".triangle")  ;
                let rectangle = document.querySelector(".rectangle") ;
                let square    = document.querySelector(".square")    ;
            
                if (line.style.left === "12%"){
                    line.style.left = "-11%" ;

                    setTimeout(() => {
                        rectangle.style.left = "12%" ;
                    }, 200) ;

                }

                else if (circle.style.left === "12%"){
                    circle.style.left = "-11%" ;

                    setTimeout(() => {
                        rectangle.style.left = "12%" ;
                    }, 200) ;

                }

                else if (ellipse.style.left === "12%"){
                    ellipse.style.left = "-11%" ;

                    setTimeout(() => {
                        rectangle.style.left = "12%" ;
                    }, 200) ;

                }

                else if (triangle.style.left === "12%"){
                    triangle.style.left = "-11%" ;

                    setTimeout(() => {
                        rectangle.style.left = "12%" ;
                    }, 200) ;

                }

                else if (square.style.left === "12%"){
                    square.style.left = "-11%" ;

                    setTimeout(() => {
                        rectangle.style.left = "12%" ;
                    }, 200) ;

                }

                else {

                    if (rectangle.style.left === "12%")
                        rectangle.style.left = "-11%" ;
                    else
                        rectangle.style.left = "12%"  ;

                }
            
            },

            showHideSquareOption : function(){
                let line      = document.querySelector(".line")      ;
                let circle    = document.querySelector(".circle")    ;
                let ellipse   = document.querySelector(".ellipse")   ;
                let triangle  = document.querySelector(".triangle")  ;
                let rectangle = document.querySelector(".rectangle") ;
                let square    = document.querySelector(".square")    ;
            
                if (line.style.left === "12%"){
                    line.style.left = "-11%" ;

                    setTimeout(() => {
                        square.style.left = "12%" ;
                    }, 200) ;

                }

                else if (circle.style.left === "12%"){
                    
                    circle.style.left = "-11%" ;

                    setTimeout(() => {
                        square.style.left = "12%" ;
                    }, 200) ;

                }

                else if (ellipse.style.left === "12%"){
                    ellipse.style.left = "-11%" ;

                    setTimeout(() => {
                        square.style.left = "12%" ;
                    }, 200) ;

                }

                else if (triangle.style.left === "12%"){
                    triangle.style.left = "-11%" ;

                    setTimeout(() => {
                        square.style.left = "12%" ;
                    }, 200) ;

                }

                else if (rectangle.style.left === "12%"){
                    rectangle.style.left = "-11%" ;

                    setTimeout(() => {
                        square.style.left = "12%" ;
                    }, 200) ;

                }

                else {

                    if (square.style.left === "12%")
                        square.style.left = "-11%" ;
                    else
                        square.style.left = "12%"  ;

                }
            
            }

        }
        
    }
</script>
  
<style scoped>
    
    @import url('https://fonts.googleapis.com/css2?family=Goldman&display=swap');

    .save div{
        width       : 35%       ;
        border      : 3px solid ;
        padding     : 20px      ;
        position    : fixed     ;
        transition  : left 1s   ;
        font-family : 'Goldman', sans-serif  ;
        background-color           : white ;
        border-top-right-radius    : 20px    ;
        border-bottom-right-radius : 20px    ;
    }

    .saveXML{
        left : -35% ;
        top  : 65%  ;
    }

    .saveJSON{
        left : -35% ;
        top  : 73%  ;   
    }

    .load div{
        width       : 35%       ;
        border      : 3px solid ;
        padding     : 20px      ;
        position    : fixed     ;
        transition  : left 1s   ;
        font-family : 'Goldman', sans-serif  ;
        background-color           : white ;
        border-top-right-radius    : 20px    ;
        border-bottom-right-radius : 20px    ;
    }

    .loadXML{
        left : -35% ;
        top  : 92%  ;
    }

    .loadJSON{

        left : -35% ;
        top  : 84%  ;   
    }

    .colorPalette{
        left             : 5.5%         ;
        top              : 15%          ;
        width            : 220px        ;
        height           : 170px        ;
        border           : 1px solid    ;
        position         : fixed        ;
        border-radius    : 10px         ;
        opacity          : 0            ;
        transition       : opacity .5s  ;
        background-color : white      ;
    }  
    .colorPalette span {
        display       : inline-block ;
        width         : 25px         ;
        height        : 25px         ;
        margin        : 5px          ;
        border-radius : 5px          ;
    }

    .black {
        background-color : black ;
    }

    .gray {
        background-color : rgb(80, 80, 80) ;
    }

    .intermediateGray{
        background-color : gray ;
    }

    .lightGray{
        background-color : rgb(150, 150, 150) ;
    }

    .veryLightGray{
        background-color : gainsboro ;
    }

    .white{
        background-color : white    ;
        border           : .1px solid ;
    }

    .red{
        background-color : red ;
    }

    .lightRed{
        background-color : rgb(255, 58, 91) ;
    }

    .pink{
        background-color : rgb(255, 103, 247) ;
    }

    .lightPurple{
        background-color : rgb(218, 110, 218) ;
    }

    .intermediatePurple{
        background-color : rgb(167, 72, 255) ;
    }

    .purple{
        background-color : rgb(94, 22, 177) ;
    }

    .sky{
        background-color : rgb(2, 138, 192) ;
    }

    .intermediateSky{
        background-color : rgb(87, 192, 233) ;
    }

    .lightSky{
        background-color : rgb(127, 255, 255) ;
    }

    .lightBlue{
        background-color : rgb(23, 186, 250) ;
    }

    .intermediateBlue{
        background-color : rgb(74, 131, 255) ;
    }

    .blue{
        background-color : rgb(18, 93, 255) ;
    }

    .green{
        background-color : rgb(1, 177, 1) ;
    }

    .intermediateGreen{
        background-color : rgb(147, 219, 40) ;
    }

    .lightGreen{
        background-color : rgb(201, 255, 121)  ;
    }

    .yellow{
        background-color : yellow ;
    }

    .lightOrange{
        background-color : rgb(255, 205, 111) ;
    }

    .orange{
        background-color : orange ;
    }

    .colorPalette span:hover{
        opacity    : .6           ;
        transition : opacity .2s  ;
    }

    .colorPalette span:active{
        opacity    : .3          ;
        transition : opacity .2s ;
    }

    .options div{
        width       : 15%       ;
        border      : 3px solid ;
        padding     : 20px      ;
        position    : fixed     ;
        transition  : left .4s  ;
        font-family : 'Goldman', sans-serif  ;
        background-color           : white ;
        border-top-right-radius    : 20px    ;
        border-bottom-right-radius : 20px    ;
    }

    .options input{
        width       : 60%  ;
        margin      : 1px  ;
        margin-left : 10px ;
        font-family : 'Goldman', sans-serif  ;
    }

    .options .btn {
        margin-top  : 5%  ;
        margin-left : 70% ;
    }

    .options .line{
        top      : 10%  ;
        left     : -11% ;
    }

    .options .circle{
        top      : 26.5%  ;
        left     : -11%   ;
    
    }

    .options .ellipse{
        top      : 40%  ;
        left     : -11% ;
    }

    .options .triangle{
        top      : 55.5%  ;
        left     : -11% ;
    }

    .options .rectangle{
        top      : 71%  ;
        left     : -11% ;
    }

    .options .square{
        top      : 87%  ;
        left     : -11% ;
    }

    .shapeBar{
        background-color : rgb(30, 30, 30) ;
        top              : 10%      ;
        left             : -2%      ;
        width            : 7%       ;
        height           : 90vh     ;
        z-index          : 2px      ;
        position         : fixed    ;
        transition       : left .4s ;
    }
    .shapeBar div{
        height          : 17%    ;
        display         : flex   ;
        align-items     : center ;
        justify-content : center ;
    }

    .shapeBar div:hover{
        background-color : rgb(50, 50, 50)    ;
        transition       : background-color .3s ;
    }

    .shapeBar div:active{
        background-color: gray ;
        transition      : background-color.2s ;
    }

    .sideBar{
        background-color : black ;
        top              : 10%     ;
        width            : 5%      ;
        height           : 90vh    ;
        position         : fixed   ;
    }
    .sideBar div{
        height          : 10%    ;
        display         : flex   ;
        align-items     : center ;
        justify-content : center ;
    }

    .sideBar div:hover{
        background-color : rgb(20, 20, 20)    ;
        transition       : background-color .3s ;
    }

    .sideBar div:active{
        background-color : gray ;
        transition       : background-color.2s ;
    }

    #container{
        left             : 5%     ;
        top              : 10%    ;
        width            : 95%    ;
        height           : 100%   ;
        position         : fixed  ;
    }
</style>