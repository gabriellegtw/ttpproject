import { useState } from "react";
import "./ProfileCreation.css";

function ProfileCreation() {
    const [name, setName] = useState("");
    const [careerStage, setCareerStage] = useState("");
    const [skills, setSkills] = useState("");
    const [goals, setGoals] = useState("");
    // This is the available time the user has to study per week
    const [availableTime, setAvailableTime] = useState("");

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

                <button>
                    Generate my learning plan!
                </button>
            </form>
        </div>
    )
}

export default ProfileCreation