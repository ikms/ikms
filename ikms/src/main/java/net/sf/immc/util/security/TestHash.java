/**
 * @(#)TestHash.java
 * Copyright (C) 2003-2010 iocn.org All rights reserved
 */
package net.sf.immc.util.security;

import net.sf.immc.util.security.hashEncrypt.HashCrypt;


/**
 * @author <b>Oxidy</b>, Copyright &#169; 2007-2010
 * @version 0.1,2010/12/29
 */
public class TestHash {
    
    public static void main(String argv[]){
        HashCrypt crypt = new HashCrypt();
        
        crypt.put_HashAlgorithm("md5");
        crypt.put_EncodingMode("hex");
        String s;
        s="Cannot find digest algorithm";
        
        String hash = "";
        hash = crypt.hashStringENC(s);
        System.out.println(hash);
    }
}
