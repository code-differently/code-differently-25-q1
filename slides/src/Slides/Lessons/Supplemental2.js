import htm from "htm";
import { createElement } from "react";
import { DemoSlide, Lesson } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Supplemental2() {
    return html`
        <${Lesson} title="How to Build A Website" lessonId="supplemental_2" subtitle="Supplemental 2">
            <section>
                <h2>Building and Managing Modern Websites</h2>
                <p>Understanding the key components and considerations</p>
            </section>

            <section>
                <h2>Essential Website Components</h2>
            </section>

            <section class="ml-bullet-slide">
                <h3>Core Pages and Features</h3>
                <ul>
                    <li class="fragment">Landing Page
                        <ul>
                            <li>First impression</li>
                            <li>Clear value proposition</li>
                            <li>Call to action</li>
                        </ul>
                    </li>
                    <li class="fragment">Legal Pages
                        <ul>
                            <li>Terms & Conditions</li>
                            <li>Privacy Policy</li>
                        </ul>
                    </li>
                    <li class="fragment">Content Features
                        <ul>
                            <li>Blog system</li>
                            <li>Contact form</li>
                        </ul>
                    </li>
                </ul>
            </section>

            <section>
                <h2>Essential Backend Systems</h2>
            </section>

            <section class="ml-bullet-slide">
                <h3>Content Management</h3>
                <ul>
                    <li class="fragment">WYSIWYG editors</li>
                    <li class="fragment">Media management</li>
                    <li class="fragment">Version control</li>
                    <li class="fragment">Content scheduling</li>
                </ul>
            </section>

            <section class="ml-bullet-slide">
                <h3>User Systems</h3>
                <ul>
                    <li class="fragment">User registration & profiles</li>
                    <li class="fragment">Role management</li>
                    <li class="fragment">Permission systems</li>
                    <li class="fragment">User preferences</li>
                </ul>
            </section>

            <section class="ml-bullet-slide">
                <h3>Integration Systems</h3>
                <ul>
                    <li class="fragment">Email systems
                        <ul>
                            <li>Transactional emails</li>
                            <li>Marketing campaigns</li>
                        </ul>
                    </li>
                    <li class="fragment">E-commerce
                        <ul>
                            <li>Payment processing</li>
                            <li>Inventory management</li>
                        </ul>
                    </li>
                </ul>
            </section>

            <section class="ml-bullet-slide">
                <h3>User Engagement</h3>
                <ul>
                    <li class="fragment">In-app notifications
                        <ul>
                            <li>Real-time updates</li>
                            <li>Push notifications</li>
                        </ul>
                    </li>
                    <li class="fragment">Feedback systems
                        <ul>
                            <li>User surveys</li>
                            <li>Feature requests</li>
                        </ul>
                    </li>
                </ul>
            </section>

            <section class="ml-bullet-slide">
                <h3>Analytics & Monitoring</h3>
                <ul>
                    <li class="fragment">User behavior tracking</li>
                    <li class="fragment">Performance metrics</li>
                    <li class="fragment">Conversion tracking</li>
                    <li class="fragment">A/B testing</li>
                </ul>
            </section>

            <section>
                <h2>Technical Cross-Cutting Concerns</h2>
            </section>

            <section class="ml-bullet-slide">
                <h3>Logging & Monitoring</h3>
                <ul>
                    <li class="fragment">System logs</li>
                    <li class="fragment">Error tracking</li>
                    <li class="fragment">Performance monitoring</li>
                    <li class="fragment">Audit trails</li>
                </ul>
            </section>

            <section class="ml-bullet-slide">
                <h3>Authentication & Authorization</h3>
                <ul>
                    <li class="fragment">User authentication
                        <ul>
                            <li>Password security</li>
                            <li>Multi-factor authentication</li>
                        </ul>
                    </li>
                    <li class="fragment">Access control
                        <ul>
                            <li>Role-based access</li>
                            <li>Resource permissions</li>
                        </ul>
                    </li>
                </ul>
            </section>

            <section class="ml-bullet-slide">
                <h3>Security Concerns</h3>
                <ul>
                    <li class="fragment">SSL/TLS encryption</li>
                    <li class="fragment">CSRF protection</li>
                    <li class="fragment">XSS prevention</li>
                    <li class="fragment">SQL injection protection</li>
                    <li class="fragment">Regular security audits</li>
                </ul>
            </section>

            <section class="ml-bullet-slide">
                <h3>Beaconing & Tracking</h3>
                <ul>
                    <li class="fragment">User activity tracking</li>
                    <li class="fragment">Performance beacons</li>
                    <li class="fragment">Error reporting</li>
                    <li class="fragment">Privacy compliance</li>
                </ul>
            </section>

            <${DemoSlide} />
        <//>`;
}

export default Supplemental2;
