/*
 * $Header: /cvsroot/saxpath/saxpath/src/java/test/org/saxpath/helpers/XPathReaderFactoryTest.java,v 1.2 2002/04/26 17:05:35 jstrachan Exp $
 * $Revision: 1.2 $
 * $Date: 2002/04/26 17:05:35 $
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
 * $Id: XPathReaderFactoryTest.java,v 1.2 2002/04/26 17:05:35 jstrachan Exp $
 */


package saxpath.helpers;

import org.saxpath.XPathReader;
import org.saxpath.SAXPathException;

import junit.framework.TestCase;

public class XPathReaderFactoryTest extends TestCase
{
    public XPathReaderFactoryTest(String name)
    {
        super( name );
    }

    public void setUp()
    {
    }

    public void tearDown()
    {
    }

    public void testDefault()
    {
        System.setProperty( XPathReaderFactory.DRIVER_PROPERTY,
                            "" );
        try
        {
            XPathReader reader = XPathReaderFactory.createReader();

            assertNotNull( reader );
        }
        catch (SAXPathException e)
        {
            fail( e.getMessage() );
        }
    }

    public void testValidByProperty()
    {
        System.setProperty( XPathReaderFactory.DRIVER_PROPERTY,
                            "org.saxpath.helpers.MockXPathReader"  );

        try
        {
            XPathReader reader = XPathReaderFactory.createReader();

            assertNotNull( reader );

            assertSame( MockXPathReader.class,
                        reader.getClass() );
        }
        catch (SAXPathException e)
        {
            fail( e.getMessage() );
        }
    }

    public void testInvalidByProperty()
    {
        System.setProperty( XPathReaderFactory.DRIVER_PROPERTY,
                            "java.lang.String" );

        try
        {
            XPathReader reader = XPathReaderFactory.createReader();

            fail( "Should have thrown SAXPathException" );
        }
        catch (SAXPathException e)
        {
            // expected and correct
        }
    }

    public void testNonExistantByProperty()
    {
        System.setProperty( XPathReaderFactory.DRIVER_PROPERTY,
                            "i.am.a.class.that.does.not.Exist" );

        try
        {
            XPathReader reader = XPathReaderFactory.createReader();

            fail( "Should have thrown SAXPathException" );
        }
        catch (SAXPathException e)
        {
            // expected and correct
        }
    }

    public void testValidExplicit()
    {
        try
        {
            XPathReader reader = XPathReaderFactory.createReader( "org.saxpath.helpers.MockXPathReader" );

            assertNotNull( reader );

            assertSame( MockXPathReader.class,
                        reader.getClass() );
        }
        catch (SAXPathException e)
        {
            fail( e.getMessage() );
        }
    }

    public void testInvalidExplicit()
    {
        try
        {
            XPathReader reader = XPathReaderFactory.createReader( "java.lang.String" );

            fail( "Should have thrown SAXPathException" );
        }
        catch (SAXPathException e)
        {
            // expected and correct
        }
    }

    public void testNonExistantExplicit()
    {
        try
        {
            XPathReader reader = XPathReaderFactory.createReader( "i.am.a.class.that.does.not.Exist" );

            fail( "Should havfe thrown SAXPathException" );
        }
        catch (SAXPathException e)
        {
            // expected and correct
        }
    }
}
