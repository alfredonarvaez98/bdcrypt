package com.bolsadeideas.springboot.app.view.CSV;


import com.bolsadeideas.springboot.app.models.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component("listar.csv")
public class ClienteCsvView extends AbstractView {


    public ClienteCsvView() {
        setContentType("text/csv");
    }

    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }


    @SuppressWarnings("unchecked")
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest httpServletRequest, HttpServletResponse response) throws Exception {

    response.setHeader("Content-Disposition","attachment; filename=\"clientes.csv\"");
    response.setContentType(getContentType());

        Page<Cliente> clientes = (Page<Cliente>) model.get("clientes");
        ICsvBeanWriter beanWriter = new CsvBeanWriter(response.getWriter(),  CsvPreference.STANDARD_PREFERENCE);

        String[] header = {"id", "nombre", "apellido", "email", "createAt"};

        for(Cliente cliente: clientes) {
            beanWriter.write(cliente, header);
        }

        beanWriter.close();
    }

}