/**
 * 
 */


(function() {
	// window.appPages.login
	var login = {
		page : {
			app : window.appPages.login,
			init : function() {
				this._initHtml();
				this._initDoms();
				this._initEvent();
			},
			_initHtml : function() {
			},
			_initDoms : function() {
				var doms = app.doms;
				doms.$form = $('#loginForm');
				doms.$username = $('.username', $form);
				doms.$password = $('.password', $form);
				doms.$submit = $('.submit', $form);
			},
			_initEvent : function() {
				var app = this.app;
				var doms = app.doms;
				doms.$submit.click(app.service.login);
			}
		},
		service : {
			app : window.appPages.login,
			ctr : app.controller,
			login : function() {
				var that = this;
				var datas = that.app.doms.$form.serialize();
				var _checkData =  function() {
					
				};
				var _loginSuccess = function(data) {
					
				};
				_checkData();
				that.ctr.ajax.login(datas, _loginSuccess);
			},
			
		},
		doms : {},
		controller : {
			datas : {},
			ajax : {
				login : function(datas, callback) {
					var that = this;
					$.ajax({
						url : '/user/login',
						method : 'post',
						data : datas,
						success : callback
					});
				}
			}
		}
	};
	window.appPages = window.appPages || {};
	if (appPages.login) throw new Error("namespace is already in use.");
	window.appPages.login = login;

})();