/*
 * $Header: /cvsroot/saxpath/saxpath/src/java/main/org/saxpath/SAXPathException.java,v 1.4 2002/06/26 22:43:39 iter Exp $
 * $Revision: 1.4 $
 * $Date: 2002/06/26 22:43:39 $
 *
 * ====================================================================
 *
 * Copyright (C) 2000-2002 werken digital.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions, and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions, and the disclaimer that follows 
 *    these conditions in the documentation and/or other materials 
 *    provided with the distribution.
 *
 * 3. The name "SAXPath" must not be used to endorse or promote products
 *    derived from this software without prior written permission.  For
 *    written permission, please contact license@saxpath.org.
 * 
 * 4. Products derived from this software may not be called "SAXPath", nor
 *    may "SAXPath" appear in their name, without prior written permission
 *    from the SAXPath Project Management (pm@saxpath.org).
 * 
 * In addition, we request (but do not require) that you include in the 
 * end-user documentation provided with the redistribution and/or in the 
 * software itself an acknowledgement equivalent to the following:
 *     "This product includes software developed by the
 *      SAXPath Project (http://www.saxpath.org/)."
 * Alternatively, the acknowledgment may be graphical using the logos 
 * available at http://www.saxpath.org/
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE SAXPath AUTHORS OR THE PROJECT
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 * ====================================================================
 * This software consists of voluntary contributions made by many 
 * individuals on behalf of the SAXPath Project and was originally 
 * created by bob mcwhirter <bob@werken.com> and 
 * James Strachan <jstrachan@apache.org>.  For more information on the 
 * SAXPath Project, please see <http://www.saxpath.org/>.
 * 
 * $Id: SAXPathException.java,v 1.4 2002/06/26 22:43:39 iter Exp $
 */



package org.saxpath;

/** Base of all SAXPath exceptions.
 *
 *  @author bob mcwhirter (bob@werken.com)
 */
public class SAXPathException extends Exception
{

    /** The source exception, if any */
    private Throwable cause;

    /** Construct with a given message.
     *
     *  @param msg The error message.
     */
    public SAXPathException(String msg)
    {
        super( msg );
    }

    /** Construct based on another exception
     *
     *  @param src The error source.
     */
    public SAXPathException(Throwable src)
    {
	super ( src.getMessage() );
	cause = src;
    }

    /** If this exception was originally caused by another exception,
     *  return it; otherwise, return <code>null</code>.
     */
    public Throwable getCause()
    {
	return cause;
    }

    /** Overriden to print this exception's stack, followed by the
     *	source exception's, if any.
     */
    public void printStackTrace ()
    {
	printStackTrace ( System.err );
    }

    /** Overriden to print this exception's stack, followed by the
     *	source exception's, if any.
     */
    public void printStackTrace ( java.io.PrintStream s )
    {
	super.printStackTrace ( s );
	if (cause != null) {
	    s.println ( "root case:" );
	    cause.printStackTrace ( s );
	}
    }

    /** Overriden to print this exception's stack, followed by the
     *	source exception's, if any.
     */
    public void printStackTrace (java.io.PrintWriter s)
    {
	super.printStackTrace ( s );
	if (cause != null) {
	    s.println ( "root case:" );
	    cause.printStackTrace ( s );
	}
    }

}
