import "./TaskContainer.css";

function TaskContainer( { title, skill, endDate, isCompleted } ) {
    const handleChange = (e) => {
        // nothing
    }
    return (
        <div className="task-container">
            <input className="checkbox"
                type="checkbox"
                checked={isCompleted}
            />
            <div className="task-info">
                <p className="task-title">
                    {title}
                </p>
                <p className="additional-info">
                    Associated Skill: {skill}
                </p>
                <p className="additional-info">
                    Deadline: {endDate}
                </p>
            </div>
        </div>
    )
}

export default TaskContainer