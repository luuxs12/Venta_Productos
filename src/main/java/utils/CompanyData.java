/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author eramos
 */
public class CompanyData {

    public static String RUC = "0987654321001";
    public static String NOMBRE = "Fantasma Cooporation";
    public static String TELEFONO = "0987654321";
    public static String DIRECCION = "Tamarindo City";
    public static String RAZON = "La magia de la programacion, esta en el poder de tu imaginacion";
   

    public static String toStringData() {
        StringBuilder data = new StringBuilder();
        return data.append("RUC: ").append(CompanyData.RUC).append("\n")
                .append("NOMBRE: ").append(CompanyData.NOMBRE).append("\n")
                .append("TELEFONO: ").append(CompanyData.TELEFONO).append("\n")
                .append("DIRECCIÓN: ").append(CompanyData.DIRECCION).append("\n")
                .append("RAZON SOCIAL: ").append(CompanyData.RAZON)
                .toString();
    }

}
