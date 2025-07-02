import axios from "axios";
import { useState } from "react";
import {Link, useNavigate} from "react-router-dom";
import "./LoginPage.css";

function LoginPage() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const res = await axios.post("http://localhost:8000/auth/login", {
                email,
                password,
            });
            alert("Login Successfully");
            navigate('/profile');
        } catch (err) {
            alert("Login failed");
        }
    }

    return (
        <div>
            <h1>Log In</h1>
            <form>
                <label>Email
                    <input className="fields"
                           type="text"
                           value={email}
                           onChange={(e) => setEmail(e.target.value)}
                           placeholder="Email"
                    />
                </label>

                <label>Password
                    <input className="fields"
                           type="password"
                           value={password}
                           onChange={(e) => setPassword(e.target.value)}
                           placeholder="Password"
                    />
                </label>

                <button type="submit" onClick={handleSubmit}>Submit</button>
            </form>
            <p style={{ marginTop: '1rem' }}>
                <span style={{ color: 'black' }}>Don't have an account? </span>
                <Link to="/register" style={{ color: 'blue', textDecoration: 'underline' }}>
                    Register
                </Link>
            </p>
        </div>
    )
}

export default LoginPage