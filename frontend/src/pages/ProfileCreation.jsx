import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./ProfileCreation.css";

function ProfileCreation() {
    const [name, setName] = useState("");
    const [careerStage, setCareerStage] = useState("");
    const [skills, setSkills] = useState("");
    const [goals, setGoals] = useState("");
    // This is the available time the user has to study per week
    const [availableTime, setAvailableTime] = useState("");
    const [hasLearningPlan, setHasLearningPlan] = useState(false);

    const navigate = useNavigate();

    const handleGenerate = async (e) => {
        // Prevent the page from refreshing when you press the button
        e.preventDefault();

        const payload = {
            userDetails: `current career stage: ${careerStage}. Goal: ${goals}. 
            Current Skills: ${skills}. Available time to study per week: ${availableTime}`
        }

        axios.post('http://localhost:8000/profile/generate', payload)
            .then(response => {
                console.log("Response: ", response.data.message)
                localStorage.setItem("curr", response.data.message);
                setHasLearningPlan(true)
        }).catch(error => console.log("Error: " + error));
    }

    const handleNavigation = (e) => {
        e.preventDefault();
        navigate("/path");
    }

    return (
        <div>
            <h1>Your profile</h1>
            <form>
                <label>Name
                    <input className="fields"
                           type="text"
                           value={name}
                           onChange={(e) => setName(e.target.value)}
                           placeholder="E.g. Alice Tan"
                    />
                </label>

                <label>Current career stage
                    <input className="fields"
                           type="text"
                           value={careerStage}
                           onChange={(e) => setCareerStage(e.target.value)}
                           placeholder="E.g. Fresh graduate from university"
                    />
                </label>

                <label>Current skills
                    <input className="fields"
                           type="text"
                           value={skills}
                           onChange={(e) => setSkills(e.target.value)}
                           placeholder="E.g. Basic Javascript, Understanding of Databases"
                    />
                </label>

                <label>Goals
                    <input className="fields"
                           type="text"
                           value={goals}
                           onChange={(e) => setGoals(e.target.value)}
                           placeholder="E.g. I want to eventually work as a backend engineer"
                    />
                </label>

                <label>Available time per week
                    <input className="fields"
                           type="text"
                           value={availableTime}
                           onChange={(e) => setAvailableTime(e.target.value)}
                           placeholder="E.g. 2 hours per week"
                    />
                </label>

                <button
                onClick={handleGenerate}>
                    Generate my learning plan!
                </button>
                { hasLearningPlan && <button
                    onClick={handleNavigation}>
                    Navigate to your learning plan →
                </button> }
            </form>
        </div>
    )
}

export default ProfileCreation