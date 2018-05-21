package com.aerolinea.control;

import com.aerolinea.reportes.Reportes;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import net.sf.jasperreports.engine.JRException;

@ManagedBean
@ViewScoped
public class controlReporteVuelos implements Serializable {

    private Date fecha1;
    private Date fecha2;
    private String tipo;
    
    public controlReporteVuelos() {
    }

    public Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void generarReporte() throws JRException, IOException{
        Reportes r = new Reportes();
        Map parametros = new HashMap();
        parametros.put("fecha1", fecha1);
        parametros.put("fecha2", fecha2);
        parametros.put("estado", " v.estado in ('DISPONIBLE','NO DISPONIBLE') ");
   r.generarReporte(parametros, tipo, "/reportes/ReporteVuelos.jasper", "Reporte");
    }
}
