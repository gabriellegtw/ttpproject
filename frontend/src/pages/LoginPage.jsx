import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
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
            alert(res.data);
        } catch (err) {
            alert("Login failed");
        }
    }

    const handleNavigation = (e) => {
        e.preventDefault();
        navigate("/path");
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

                <button type="submit">Submit</button>
            </form>
        </div>
    )
}

export default LoginPage