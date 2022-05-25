
let jsonlist1; // 차트1 사용될 json 
let jsonlist2; // 차트2 사용될 json


$( function(){
	
	
	// 1. 일별 매출 차트 데이터
	// 2. 카테고리별 전체 판매수량 데이터
	
	$.ajax({
		url : "getchart", // 서블릿 생성
		data : { "type" : 1 } , 
		success : function(re){
			console.log(re);
			jsonlist1 = re;

//////////////////////////////////////////에이엠 차트/////	
	am5.ready(function() {
	
	// Create root element
	// https://www.amcharts.com/docs/v5/getting-started/#Root_element
	var root = am5.Root.new("chartdiv1");
	
	
	// Set themes
	// https://www.amcharts.com/docs/v5/concepts/themes/
	root.setThemes([
	  am5themes_Animated.new(root)
	]);
	
	
	// Create chart
	// https://www.amcharts.com/docs/v5/charts/xy-chart/
	var chart = root.container.children.push(am5xy.XYChart.new(root, {
	  panX: false,
	  panY: false,
	  wheelX: "panX",
	  wheelY: "zoomX"
	}));
	
	
	// Add cursor
	// https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
	var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {
	  behavior: "zoomX"
	}));
	cursor.lineY.set("visible", false);
	
//	var date = new Date(); 
	
	
	function generateData(i) {
	//1. i번째 객체에서 값 가져오기
	let value = parseInt( jsonlist1[i]["value"] );
//	  value = jsonlist[i]["value"];	  
	//1. i번째 객체에서 날짜 가져오기
//	  jsonlist[i]["date"];
	  
	  //형변환
	  //문자열 -> 날짜형식 [new date(문자열)];
	 let date = new Date( jsonlist1[i]["date"] );
	  
	  // Math.round((Math.random() * 10 - 5) + value);
	  
	  date.setHours(0,0,0,0);
	  am5.time.add(date, "day", 1);
	  
	  return {
	    date: date.getTime(),
	    value: value
	  };
	}
	
	function generateDatas(count) {
	  var data = [];
	  for (var i = 0; i < count; ++i) {
	    data.push(generateData(i)); // 객체 인덱스번호 i 를 인수로 전달 
	  }
	  return data;
	}
	
	
	// Create axes
	// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
	var xAxis = chart.xAxes.push(am5xy.DateAxis.new(root, {
	  maxDeviation: 0,
	  baseInterval: {
	    timeUnit: "day",
	    count: 1
	  },
	  renderer: am5xy.AxisRendererX.new(root, {}),
	  tooltip: am5.Tooltip.new(root, {})
	}));
	
	var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
	  renderer: am5xy.AxisRendererY.new(root, {})
	}));
	
	
	// Add series
	// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
	var series = chart.series.push(am5xy.ColumnSeries.new(root, {
	  name: "Series",
	  xAxis: xAxis,
	  yAxis: yAxis,
	  valueYField: "value",
	  valueXField: "date",
	  tooltip: am5.Tooltip.new(root, {
	    labelText: "{valueY}"
	  })
	}));
	
	
	
	// Add scrollbar
	// https://www.amcharts.com/docs/v5/charts/xy-chart/scrollbars/
	chart.set("scrollbarX", am5.Scrollbar.new(root, {
	  orientation: "horizontal"
	}));
	
var data = generateDatas( jsonlist.length ); //차트에 들어가는 데이터 [ 인수 : 객체수 ]
series.data.setAll(data);
	
	
	// Make stuff animate on load
	// https://www.amcharts.com/docs/v5/concepts/animations/
	series.appear(1000);
	chart.appear(1000, 100);
	
	}); // end am5.ready()
	
//////////////////////////////////////////////////
	
$.ajax({
	url : "getchart", // 서블릿 생성
	data : { "type" : 2 } , 
	success : function(re){
	console.log(re);
	jsonlist2 = re;

am5.ready(function() {
	// Create root element
	// https://www.amcharts.com/docs/v5/getting-started/#Root_element
	var root = am5.Root.new("chartdiv2");
	
	
	// Set themes
	// https://www.amcharts.com/docs/v5/concepts/themes/
	root.setThemes([
	  am5themes_Animated.new(root)
	]);
	
	
	// Create chart
	// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/
	var chart = root.container.children.push(am5percent.PieChart.new(root, {
	  layout: root.verticalLayout,
	  innerRadius: am5.percent(50)
	}));
	
	
	// Create series
	// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Series
	var series = chart.series.push(am5percent.PieSeries.new(root, {
	  valueField: "value",
	  categoryField: "category",
	  alignLabels: false
	}));
	
	series.labels.template.setAll({
	  textType: "circular",
	  centerX: 0,
	  centerY: 0
	});
	
	
	// Set data
	// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Setting_data
	series.data.setAll( jsonlist2 );
	
	
	// Create legend
	// https://www.amcharts.com/docs/v5/charts/percent-charts/legend-percent-series/
	var legend = chart.children.push(am5.Legend.new(root, {
	  centerX: am5.percent(50),
	  x: am5.percent(50),
	  marginTop: 15,
	  marginBottom: 15,
	}));
	
	legend.data.setAll(series.dataItems);
	
	
	// Play initial series animation
	// https://www.amcharts.com/docs/v5/concepts/animations/#Animation_of_series
	series.appear(1000, 100);

}); // end am5.ready()


///////////////////////////////////////
		} 
	}); //아자트 2

		}
	}); // ajax1 end 
});
