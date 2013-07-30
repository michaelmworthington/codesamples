function ReservationsCtrl ($scope, Reservations, Flights) {
	$scope.setActive('reservations');
	$scope.reservenotfound = 'false';
	$scope.reserveerror = 'false';
	$scope.reservesuccess = 'false';

	$scope.reservations = Reservations.query();
	$scope.flights = Flights.query();

	$scope.reserveFlight = function  () {
		Reservations.save($scope.reserve, 
				function (successData) {
			        $scope.reserve.origin = '';
			        $scope.reserve.destination = '';

			        $scope.reservesuccess = 'true';
			        $scope.reservations.push(successData);
		        },
		        function (errorData) {
		        	if(errorData.status == 404)
		        	{
		        		$scope.reservenotfound = 'true';
		        		$scope.reserveerrorstatus = errorData.status;
		        	}
		        	else
		        	{
		        		$scope.reserveerror = 'true';
		        		$scope.reserveerrorstatus = errorData.status;
		        	}
		        });
	}
}