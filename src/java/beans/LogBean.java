/*
 * Copyright 2016 Len Payne <len.payne@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package beans;

import java.util.Date;
import javax.enterprise.context.RequestScoped;

/**
 * This is a Request Scoped bean that simply helps format server logs
 * consistently
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
@RequestScoped
public class LogBean {

    public void log(String msg) {
        System.out.println(new Date() + ": " + msg);
    }
}
