/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author just1689
 */
@NoArgsConstructor
public class DatabaseConnectionDetail {
    
    @Getter
    @Setter
    private String host;
    
    @Getter
    @Setter
    private int port;
    
    @Getter
    @Setter
    private String username;
    
    @Getter
    @Setter
    private String password;
    
}
