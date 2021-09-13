package com.eugenedatsenko.web.tag;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.ResourceBundle;

public class AlertTag extends TagSupport {

    private static final long serialVersionUID = -6502032363620510608L;

    private String type;

    private String form;

    public void setType(String type) {
        this.type = type;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public int doStartTag() {
        try {
            ResourceBundle resource = type.equals("ru")
                    ? ResourceBundle.getBundle("resources_ru")
                    : ResourceBundle.getBundle("resources_en");
            String message = form.equals("login")
                    ? resource.getString("login_jsp.error.alert")
                    : resource.getString("register_jsp.error.alert");
            pageContext.getOut().println(alert(message, new StringBuilder()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    public String alert(String message, StringBuilder stringBuilder) {
        return stringBuilder
                .append("<div class=\"info alert alert-danger\" role=\"alert\">")
                .append(message)
                .append("</div>")
                .toString();
    }
}
