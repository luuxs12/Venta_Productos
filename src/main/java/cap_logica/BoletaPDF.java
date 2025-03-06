package cap_logica;

import cap_logica.model.TDetalle;
import cap_logica.model.TBoletaPDF;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import utils.CalendarTime;
import utils.CompanyData;

/**
 *
 * @author eramos
 */
public class BoletaPDF {

    //metodo para generar la boleta de venta
    public void generateBoletaPDF(TBoletaPDF boleta) {
        try {
            String fechaActual = CalendarTime.getCurrentDate();
            String nombreCompleto = boleta.getCliente().getNombre() + " " + boleta.getCliente().getApellido();
            int boletaId = boleta.getDetalles().get(0).getIdBoleta();
            String nombreArchivoPDFVenta = "Venta_V-" + boletaId + "_" + boleta.getCliente().getNombre() + "_" + fechaActual + ".pdf";

            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Image img = Image.getInstance("src/main/java/cap_img/ventas.png");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE); //agregar nueva linea
            fecha.add("Factura: V-" + boletaId + "\nFecha: " + fechaActual + "\n\n");

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);//quitar el borde de la tabla
            //tamaño de las celdas
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //agregar celdas
            Encabezado.addCell(img);

            // Añadimos datos de la Empresa
            Encabezado.addCell(fecha);
            doc.add(Encabezado);
            Encabezado.addCell("");//celda vacia

            Encabezado.addCell(CompanyData.toStringData());
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            //CUERPO
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);//nueva linea
            cliente.add("Datos del cliente: " + "\n\n");
            doc.add(cliente);

            //DATOS DEL CLIENTE
            PdfPTable tablaCliente = new PdfPTable(2);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);//quitar bordes
            //tamaño de las celdas
            float[] ColumnaCliente = new float[]{25f, 45f};
            tablaCliente.setWidths(ColumnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("DNI: " + boleta.getCliente().getDni(), negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre: " + nombreCompleto, negrita));
            //quitar bordes 
            cliente1.setBorder(0);
            cliente2.setBorder(0);

            //agg celda a la tabla
            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);

            //agregar al documento
            doc.add(tablaCliente);

            //ESPACIO EN BLANCO
            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);

            //AGREGAR LOS PRODUCTOS
            PdfPTable tablaProducto = new PdfPTable(3);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            //tamaño de celdas
            float[] ColumnaProducto = new float[]{15f, 50f, 15f};
            tablaProducto.setWidths(ColumnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("Producto: ", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Precio Total: ", negrita));
            //quitar bordes
            producto1.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            //agregar color al encabezadi del producto
            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            //agg celda a la tabla
            tablaProducto.addCell(producto1);
            tablaProducto.addCell(producto3);
            tablaProducto.addCell(producto4);
            
            ProductDAO productDao = new ProductDAO();
            
            //agrega detalles de venta
            for (TDetalle detalle : boleta.getDetalles()) {
                String producto = productDao.consultarPorId(detalle.getIdProducto()).getNombre();
                String cantidad = String.valueOf(detalle.getCantidad());
                String total = String.valueOf(detalle.getPrecioVenta());
                tablaProducto.addCell(cantidad);
                tablaProducto.addCell(producto);
                tablaProducto.addCell(total);
            }

            //agregar al documento
            doc.add(tablaProducto);

            //Total pagar
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a pagar: " + boleta.calcularTotalVenta());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            //Firma
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelacion y firma\n\n");
            firma.add("_______________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            //Mensaje
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("¡Gracias por su compra!");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);

            //cerrar el documento y el archivo
            doc.close();
            archivo.close();

            //abrir el documento al ser generado automaticamente
            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        }
    }
   
}
