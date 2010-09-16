/*
 * @(#)Sun.java	1.4 97/03/21 
 *
 * Copyright (c) 1997 Sun Microsystems, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Sun
 * Microsystems, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 *
 * SUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

package sun.security.provider;

import java.io.*;
import java.util.*;
import java.security.*;

/**
 * Defines the SUN provider.
 *
 * <i> Note - this example requires JDK 1.1.1 </i>
 * 
 * Algorithm supported, and their names:
 *
 * - SHA-1 is the message digest scheme decribed FIPS 180-1. 
 *   Aliases for SHA-1 are SHA.
 *
 * - DSA is the signature scheme described in FIPS 186.  (SHA used in
 *   DSA is SHA-1: FIPS 186 with Change No 1.)  Aliases for DSA are
 *   SHA/DSA, SHA-1/DSA, DSS and the object identifier (OID) string
 *   "OID:1.3.14.3.2.13".
 *
 * - DSA is the key generation scheme as described in FIPS 186.
 *   Aliases for DSA include the OID string "OID:1.3.14.3.2.12".
 *
 * - MD5 is the message digest scheme described in RFC 1321.
 *   There are no aliases for MD5.
 *
 * Notes: The name of algorithm described in FIPS-180 is SHA-0, and is
 * not supported by the SUN provider.)  
 *
 * @author Benjamin Renaud
 * 
 * @version 1.4 97/06/30
 */
public final class Sun extends Provider {

    private static String info = "SUN Security Provider v1.0, " + 
    "DSA signing and key generation, SHA-1 and MD5 message digests.";

    public Sun() {
	/* We are the SUN provider */
	super("SUN", 1.0, info);

	/*
	 * Signature engines 
	 */
	put("Signature.DSA", "sun.security.provider.DSA");

	put("Alg.Alias.Signature.SHA/DSA", "DSA");
	put("Alg.Alias.Signature.SHA-1/DSA", "DSA");
	put("Alg.Alias.Signature.DSS", "DSA");
	put("Alg.Alias.Signature.OID:1.3.14.3.2.13", "DSA");

	/*
	 *  Key Pair Generator engines 
	 */
	put("KeyPairGenerator.DSA", 
	    "sun.security.provider.DSAKeyPairGenerator");
	put("Alg.Alias.KeyPairGenerator.OID:1.3.14.3.2.12", "DSA");

	/* 
	 * Digest engines 
	 */
	put("MessageDigest.MD5", "sun.security.provider.MD5");
	put("MessageDigest.SHA-1", "sun.security.provider.SHA");
	
	put("Alg.Alias.MessageDigest.SHA", "SHA-1");

	/*
	 * Algorithm name aliases 
	 */

	/* Algorithm properties. Used by sun.security.x509.AlgorithmId.
	   This is a standard way to specify non-standard properties. */
	put("Alg.Class.DSA", "sun.security.x509.AlgIdDSA");
	put("Alg.Class.1.3.14.3.2.12", "sun.security.x509.AlgIdDSA");
	
	/* Ignore everything below this line. */

	/* This is unsupported, but left there until we fix
           AlgorithmId. */
	put("Alg.Alias.Signature.1.3.14.3.2.13", "DSA");
	put("Alg.Alias.Signature.SHAwithDSA", "DSA");
	put("Alg.Alias.Signature.SHA1withDSA", "DSA");
	put("Alg.Alias.KeyPairGenerator.1.3.14.3.2.12", "DSA");

	/* Key types. Internal to sun.* */
	put("PublicKey.X.509.DSA", "sun.security.provider.DSAPublicKey");
	put("PrivateKey.PKCS#8.DSA", "sun.security.provider.DSAPrivateKey");
    }
}
