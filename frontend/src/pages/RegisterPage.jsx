import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./LoginPage.css";

function RegisterPage() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");

    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        // Prevent the page from refreshing when you press the button
        e.preventDefault();

        if (password !== confirmPassword) {
            alert("Please ensure that your passwords are the same");
        } else {
            try {
                const formData = {
                    email: email,
                    password: password,
                };

                const res = await axios.post("http://localhost:8000/auth/register", formData);
                alert(res.data);
            } catch (err) {
                alert(err.response.data)
            }
        }
    }

    const handleNavigation = (e) => {
        e.preventDefault();
        navigate("/path");
    }

    return (
        <div>
            <h1>Register</h1>
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

                <label>Confirm Password
                    <input className="fields"
                           type="password"
                           value={confirmPassword}
                           onChange={(e) => setConfirmPassword(e.target.value)}
                           placeholder="Password"
                    />
                </label>

                <button type="submit">Submit</button>
            </form>
        </div>
    )
}

export default RegisterPage