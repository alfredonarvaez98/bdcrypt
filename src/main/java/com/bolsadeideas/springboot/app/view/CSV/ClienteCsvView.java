package com.bolsadeideas.springboot.app.view.CSV;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component("listar")
public class ClienteCsvView extends AbstractView {


    public ClienteCsvView() {
        setContentType("text/csv");
    }

    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest httpServletRequest, HttpServletResponse response) throws Exception {

    response.setHeader("Content-Disposition","attachment; filename=\"clientes.csv\"");
    response.setContentType(getContentType());


    }
}
