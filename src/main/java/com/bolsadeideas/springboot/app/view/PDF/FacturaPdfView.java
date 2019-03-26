package com.bolsadeideas.springboot.app.view.PDF;


import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component("factura/ver")
public class FacturaPdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        Factura factura = (Factura) model.get("factura");

        PdfPTable tabla = new PdfPTable(1);
        tabla.addCell("Datos del cliente");
        tabla.addCell(factura.getCliente().getNombre()+"   "+factura.getCliente().getApellido());

        PdfPTable tabla2 = new PdfPTable(1);
        tabla.addCell("Datos de la factura");
        tabla.addCell("Folio: "+factura.getId());
        tabla.addCell("Descripcion: "+factura.getDescripcion());
        tabla.addCell("Fecha: "+factura.getCreateAt());


        document.add(tabla);
        document.add(tabla2);

    }
}
