<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Material Design Bootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.2/css/mdb.min.css"
	rel="stylesheet">
<link
	href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.min.css"
	rel="stylesheet">

</head>
<body>
	<div style="text-align: center; padding-top: 30px; border: blue;">
		<div class="d-flex justify-content-center">
			<label class="text-primary">Search:</label> &nbsp;<input type="text"
				class="border border-danger" name="searchText" id="searchText" />
		</div>
	</div>

	<h2 id="searchResultMessage" style="display:none;"></h2>
	
	<div id="searchResult" style="display:none;">
		<h2 class="text-primary">Search Results</h2>
		<table class="table table-striped table-bordered table-sm"
			cellspacing="0" width="100%" id="searchResultTable">
			<thead>
				<tr>
					<td>ID</td>
					<td>Country</td>
				</tr>
			</thead>
			<tbody id="result">
			</tbody>
		</table>
	</div>
		
	<script type="text/javascript">
		$(document).ready(function() {
			$('#searchText').on('keyup', function() {
				search();
			});

			function search() {
				$.ajax({
					type : "GET",
					url : "${pageContext.request.contextPath}/load/fetch",
					data : "searchText=" + $("#searchText").val(),
					success : function(res) {
						var result = "";
						console.log(res)
						$.each(res, function(k, v) {
							console.log(k, v)
							result += "<tr>";
							result += "<td>" + (k + 1) + "</td>";
							result += "<td>" + v + "</td>";
							result += "</tr>";
						});

						$("#result").html(result);
						$("#searchResultMessage").hide();
						$("#searchResult").show();
					},
					error : function() {
						$("#searchResult").hide();
						$("#searchResultMessage").text("Search Text cannot be null or empty!").show();
					}
				});
			}
		});
	</script>
</body>
</html>
