//   The contents of this file are subject to the Mozilla Public License
//   Version 1.1 (the "License"); you may not use this file except in
//   compliance with the License. You may obtain a copy of the License at
//   http://www.mozilla.org/MPL/
//
//   Software distributed under the License is distributed on an "AS IS"
//   basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
//   License for the specific language governing rights and limitations
//   under the License.
//
//   The Original Code is RabbitMQ.
//
//   The Initial Developers of the Original Code are LShift Ltd,
//   Cohesive Financial Technologies LLC, and Rabbit Technologies Ltd.
//
//   Portions created before 22-Nov-2008 00:00:00 GMT by LShift Ltd,
//   Cohesive Financial Technologies LLC, or Rabbit Technologies Ltd
//   are Copyright (C) 2007-2008 LShift Ltd, Cohesive Financial
//   Technologies LLC, and Rabbit Technologies Ltd.
//
//   Portions created by LShift Ltd are Copyright (C) 2007-2009 LShift
//   Ltd. Portions created by Cohesive Financial Technologies LLC are
//   Copyright (C) 2007-2009 Cohesive Financial Technologies
//   LLC. Portions created by Rabbit Technologies Ltd are Copyright
//   (C) 2007-2009 Rabbit Technologies Ltd.
//
//   All Rights Reserved.
//
//   Contributor(s): ______________________________________.
//
package com.rabbitmq.utility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Catch-all holder class for static helper methods.
 */

public class Utility {
  
    public static String makeStackTrace(Throwable throwable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        throwable.printStackTrace(printStream);
        String text = new String(outputStream.toByteArray());
        printStream.close();
        try {
            outputStream.close();
        } catch (IOException ex) {
            // Closing the output stream won't generate an error, and in 
            // fact does nothing - just being tidy
            ex.printStackTrace();
        }
        return text;
    }

    /**
     * Used to indicate that we are not, in fact, using a variable, also to silence compiler warnings.
     *
     * @param value the object we're pretending to use
     */
    public static void use(Object value) {
        if (value != null) {
            return;
        }
    }

    /**
     * Similarly, for situations where an empty statement is required
     */
    public static void emptyStatement() {
        use(null);
    }
}