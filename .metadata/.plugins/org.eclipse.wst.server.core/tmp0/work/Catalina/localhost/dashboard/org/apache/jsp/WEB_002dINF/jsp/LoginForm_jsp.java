/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-03-04 11:45:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LoginForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-3.0.1.RELEASE.jar", Long.valueOf(1456206360000L));
    _jspx_dependants.put("jar:file:/Users/test/Documents/git/DashBoardE/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/dashboard/WEB-INF/lib/spring-webmvc-3.0.1.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1266488822000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ff_005fform_0026_005fmodelAttribute_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ff_005finput_0026_005ftype_005fplaceholder_005fpath_005fonclick_005fclass_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ff_005finput_0026_005ftype_005fplaceholder_005fpath_005fclass_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005ff_005fform_0026_005fmodelAttribute_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ff_005finput_0026_005ftype_005fplaceholder_005fpath_005fonclick_005fclass_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ff_005finput_0026_005ftype_005fplaceholder_005fpath_005fclass_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ff_005fform_0026_005fmodelAttribute_005faction.release();
    _005fjspx_005ftagPool_005ff_005finput_0026_005ftype_005fplaceholder_005fpath_005fonclick_005fclass_005fnobody.release();
    _005fjspx_005ftagPool_005ff_005finput_0026_005ftype_005fplaceholder_005fpath_005fclass_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    <!-- Latest compiled and minified CSS -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<!-- Optional theme -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css\" integrity=\"sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<!-- Latest compiled and minified JavaScript -->\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\" integrity=\"sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write(" \r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Login</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("@import url(http://weloveiconfonts.com/api/?family=entypo);\r\n");
      out.write("@import url(http://fonts.googleapis.com/css?family=Roboto);\r\n");
      out.write("\r\n");
      out.write("/* zocial */\r\n");
      out.write("[class*=\"entypo-\"]:before {\r\n");
      out.write("  font-family: 'entypo', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("*,\r\n");
      out.write("*:before,\r\n");
      out.write("*:after \r\n");
      out.write("{\r\n");
      out.write("  -moz-box-sizing: border-box; \r\n");
      out.write("  -webkit-box-sizing: border-box;\r\n");
      out.write("  box-sizing: border-box; \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("h2 {\r\n");
      out.write("  color:rgba(255,255,255,.8);\r\n");
      out.write("  margin-left:12px;\r\n");
      out.write("}\r\n");
      out.write("h5 {\r\n");
      out.write("  color:rgba(255,255,255,.8);\r\n");
      out.write("  margin-left:12px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("  background: #272125;\r\n");
      out.write("  font-family: 'Roboto', sans-serif;\r\n");
      out.write("  \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("form {\r\n");
      out.write("  position:relative;\r\n");
      out.write("  margin: 50px auto;\r\n");
      out.write("  width: 380px;\r\n");
      out.write("  height: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input {\r\n");
      out.write("  padding: 16px;\r\n");
      out.write("  border-radius:7px;\r\n");
      out.write("  border:0px;\r\n");
      out.write("  background: rgba(255,255,255,.2);\r\n");
      out.write("  display: block;\r\n");
      out.write("  margin: 15px;\r\n");
      out.write("  width: 300px;  \r\n");
      out.write("  color:white;\r\n");
      out.write("  font-size:18px;\r\n");
      out.write("  height: 54px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input:focus {\r\n");
      out.write("  outline-color: rgba(0,0,0,0);\r\n");
      out.write("  background: rgba(255,255,255,.95);\r\n");
      out.write("  color: #e74c3c;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button {\r\n");
      out.write("  float:right;\r\n");
      out.write("  height: 121px;\r\n");
      out.write("  width: 50px;\r\n");
      out.write("  border: 0px;\r\n");
      out.write("  background: #e74c3c;\r\n");
      out.write("  border-radius:7px;\r\n");
      out.write("  padding: 10px;\r\n");
      out.write("  color:white;\r\n");
      out.write("  font-size:22px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".inputUserIcon {\r\n");
      out.write("  position:absolute;\r\n");
      out.write("  top:68px;\r\n");
      out.write("  right: 80px;\r\n");
      out.write("  color:white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".inputPassIcon {\r\n");
      out.write("  position:absolute;\r\n");
      out.write("  top:136px;\r\n");
      out.write("  right: 80px;\r\n");
      out.write("  color:white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input::-webkit-input-placeholder {\r\n");
      out.write("  color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input:focus::-webkit-input-placeholder {\r\n");
      out.write("  color: #e74c3c;\r\n");
      out.write("}\r\n");
      out.write(".al\r\n");
      out.write("{\r\n");
      out.write("\tmargin-left: 200px;\r\n");
      out.write("\tmargin-right: 200px;\r\n");
      out.write("\tmargin-top: 150px;\r\n");
      out.write("}\r\n");
      out.write(".do\r\n");
      out.write("{\r\n");
      out.write("\ttext-align: right;\r\n");
      out.write("\tcolor: green;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function evalid(email)\r\n");
      out.write("{\r\n");
      out.write("\tdocument.getElementById(\"di\").innerHTML =\"Click To Login\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("\t\r\n");
      if (_jspx_meth_f_005fform_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_f_005fform_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  f:form
    org.springframework.web.servlet.tags.form.FormTag _jspx_th_f_005fform_005f0 = (org.springframework.web.servlet.tags.form.FormTag) _005fjspx_005ftagPool_005ff_005fform_0026_005fmodelAttribute_005faction.get(org.springframework.web.servlet.tags.form.FormTag.class);
    _jspx_th_f_005fform_005f0.setPageContext(_jspx_page_context);
    _jspx_th_f_005fform_005f0.setParent(null);
    // /WEB-INF/jsp/LoginForm.jsp(142,0) name = action type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_f_005fform_005f0.setAction("LoginForm.html");
    // /WEB-INF/jsp/LoginForm.jsp(142,0) name = modelAttribute type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_f_005fform_005f0.setModelAttribute("index");
    int[] _jspx_push_body_count_f_005fform_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_f_005fform_005f0 = _jspx_th_f_005fform_005f0.doStartTag();
      if (_jspx_eval_f_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("  <h2><span class=\"entypo-login\"></span> Login</h2>\r\n");
          out.write("  \r\n");
          out.write("  <button type=\"submit\" value=\"Login\" class=\"submit\"><span class=\"entypo-lock\"></span></button>\r\n");
          out.write("  \r\n");
          out.write("  <span class=\"entypo-user inputUserIcon\"></span>\r\n");
          out.write("  ");
          if (_jspx_meth_f_005finput_005f0(_jspx_th_f_005fform_005f0, _jspx_page_context, _jspx_push_body_count_f_005fform_005f0))
            return true;
          out.write("\r\n");
          out.write("  <span class=\"entypo-key inputPassIcon\"></span>\r\n");
          out.write("  ");
          if (_jspx_meth_f_005finput_005f1(_jspx_th_f_005fform_005f0, _jspx_page_context, _jspx_push_body_count_f_005fform_005f0))
            return true;
          out.write("\r\n");
          out.write(" <!--  <div class=\"do\" id=\"di\">Click To Register</div> -->\r\n");
          out.write("  <div class=\"form-group\">\r\n");
          out.write("  <div class=\"col-md-12 control\">\r\n");
          out.write("  <div style=\"border-top: 1px solid#888; padding-top:15px; font-size:85%\" >\r\n");
          out.write("  <p style=\"color:#CFCECF\" align=\"center\">Don't have an account!\r\n");
          out.write("  <a href=\"RegistrationForm.html\" >\r\n");
          out.write("  Sign Up Here\r\n");
          out.write("  </a></p>\r\n");
          out.write("  </div>\r\n");
          out.write("  </div>\r\n");
          out.write("  </div>\r\n");
          int evalDoAfterBody = _jspx_th_f_005fform_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_f_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_f_005fform_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_f_005fform_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_f_005fform_005f0.doFinally();
      _005fjspx_005ftagPool_005ff_005fform_0026_005fmodelAttribute_005faction.reuse(_jspx_th_f_005fform_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_f_005finput_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_f_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_f_005fform_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  f:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_f_005finput_005f0 = (org.springframework.web.servlet.tags.form.InputTag) _005fjspx_005ftagPool_005ff_005finput_0026_005ftype_005fplaceholder_005fpath_005fonclick_005fclass_005fnobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_f_005finput_005f0.setPageContext(_jspx_page_context);
    _jspx_th_f_005finput_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_005fform_005f0);
    // /WEB-INF/jsp/LoginForm.jsp(148,2) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_f_005finput_005f0.setPath("pId");
    // /WEB-INF/jsp/LoginForm.jsp(148,2) null
    _jspx_th_f_005finput_005f0.setDynamicAttribute(null, "type", "text");
    // /WEB-INF/jsp/LoginForm.jsp(148,2) null
    _jspx_th_f_005finput_005f0.setDynamicAttribute(null, "class", "user");
    // /WEB-INF/jsp/LoginForm.jsp(148,2) null
    _jspx_th_f_005finput_005f0.setDynamicAttribute(null, "placeholder", "ursername");
    // /WEB-INF/jsp/LoginForm.jsp(148,2) name = onclick type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_f_005finput_005f0.setOnclick("evalid(this.value)");
    int[] _jspx_push_body_count_f_005finput_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_f_005finput_005f0 = _jspx_th_f_005finput_005f0.doStartTag();
      if (_jspx_th_f_005finput_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_f_005finput_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_f_005finput_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_f_005finput_005f0.doFinally();
      _005fjspx_005ftagPool_005ff_005finput_0026_005ftype_005fplaceholder_005fpath_005fonclick_005fclass_005fnobody.reuse(_jspx_th_f_005finput_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_f_005finput_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_f_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_f_005fform_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  f:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_f_005finput_005f1 = (org.springframework.web.servlet.tags.form.InputTag) _005fjspx_005ftagPool_005ff_005finput_0026_005ftype_005fplaceholder_005fpath_005fclass_005fnobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_f_005finput_005f1.setPageContext(_jspx_page_context);
    _jspx_th_f_005finput_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_005fform_005f0);
    // /WEB-INF/jsp/LoginForm.jsp(150,2) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_f_005finput_005f1.setPath("password");
    // /WEB-INF/jsp/LoginForm.jsp(150,2) null
    _jspx_th_f_005finput_005f1.setDynamicAttribute(null, "type", "password");
    // /WEB-INF/jsp/LoginForm.jsp(150,2) null
    _jspx_th_f_005finput_005f1.setDynamicAttribute(null, "class", "pass");
    // /WEB-INF/jsp/LoginForm.jsp(150,2) null
    _jspx_th_f_005finput_005f1.setDynamicAttribute(null, "placeholder", "password");
    int[] _jspx_push_body_count_f_005finput_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_f_005finput_005f1 = _jspx_th_f_005finput_005f1.doStartTag();
      if (_jspx_th_f_005finput_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_f_005finput_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_f_005finput_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_f_005finput_005f1.doFinally();
      _005fjspx_005ftagPool_005ff_005finput_0026_005ftype_005fplaceholder_005fpath_005fclass_005fnobody.reuse(_jspx_th_f_005finput_005f1);
    }
    return false;
  }
}
