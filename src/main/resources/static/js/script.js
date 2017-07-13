var demo = angular.module('main', []);

demo.directive('EnfermedadType', function() {
  return {
    restrict: "E",
    scope: {},
    templateUrl:'../view/enfermedadType',
    controller: function($rootScope, $scope, $element) {
      $scope.contacts = $rootScope.GetContactTypes;
      $scope.Delete = function(e) {
        //remove element and also destoy the scope that element
        $element.remove();
        $scope.$destroy();
      }
    }
  }
});

demo.controller("EnfermedadCtrl", ['$rootScope', '$scope', '$compile', '$element', '$filter', 'ContactTypesService', function($rootScope, $scope, $compile, $element, $filter) {

	//  $rootScope.GetContactTypes = ContactTypesService.ContactTypes();
	  
	  var employee={firstName:'',lastName:'',contacts:''}
	  var employeeList = [];
	  $scope.AddContactTypeControl() = function() {
	    var divElement = angular.element(document.querySelector('#contactTypeDiv'));
	    var appendHtml = $compile('<contact-Type></contact-Type>')($scope);
	    divElement.append(appendHtml);
	  }
	  var GetContactType = function(id) {
	    return $filter('filter')($rootScope.GetContactTypes, {
	      contactId: id
	    })[0].contactType;
	  }
	  var retriveValue = function() {
	    // http://stackoverflow.com/questions/12649080/get-to-get-all-child-scopes-in-angularjs-given-the-parent-scope
	    var UserContacts = [];
	    var ChildHeads = [$scope.$$childHead];
	    var currentScope;
	    while (ChildHeads.length) {
	      currentScope = ChildHeads.shift();
	      while (currentScope) {
	        if (currentScope.ContactType !== undefined)
	          UserContacts.push({
	            ContactType: GetContactType(currentScope.ContactType),
	            ContactValue: currentScope.ContactValue
	          });

	        currentScope = currentScope.$$nextSibling;
	      }
	    }
	    return UserContacts;
	  }

	  var ClearControls = function(allContacts) {
	    var i;
	    for (i = 0; i < allContacts.length; i++)
	      angular.element(allContacts[i]).remove();

	    $scope.employee = '';
	    $scope.employee.contacts = '';
	    $scope.$$childHead = $scope.$new(true);

	  }

	  $scope.OnSave = function(emp) {
	  
	   if(emp!==null && emp!==undefined){
	    emp.contacts = retriveValue($scope);
	    employeeList.push(emp);
	    $scope.EmployeeList = employeeList;
	    var allContacts = angular.element(document.getElementsByTagName("contact-Type"));
	    ClearControls(allContacts);
	   }
	  }


	}]);

demo.service("ContactTypesService", [function() {
	  var list = [];
	  return {
	    ContactTypes: function() {
	      list.push({contactId: 1,contactType: 'Mobile'});
	      list.push({contactId: 2,contactType: 'Office'});
	      list.push({contactId: 3,contactType: 'Home'});
	      list.push({contactId: 4,contactType: 'Fax'});
	      list.push({contactId: 5,contactType: 'Landline'});
	      list.push({contactId: 6,contactType: 'Other'});
	      return list;
	    }
	  }
	}]);
